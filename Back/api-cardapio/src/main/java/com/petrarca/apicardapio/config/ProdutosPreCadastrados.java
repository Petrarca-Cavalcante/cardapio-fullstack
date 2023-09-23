package com.petrarca.apicardapio.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petrarca.apicardapio.model.Produto;
import com.petrarca.apicardapio.repository.ProdutoRepository;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class ProdutosPreCadastrados {

    private final ProdutoRepository produtoRepository;

    public ProdutosPreCadastrados(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostConstruct
    public void initialize() {
        List<Produto> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) {
            try {
                ClassPathResource resource = new ClassPathResource("produtos-mockados.json");
                byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
                String json = new String(data, StandardCharsets.UTF_8);
                
                ObjectMapper objectMapper = new ObjectMapper();
                List<Produto> mockeProdutos = objectMapper.readValue(json, new TypeReference<List<Produto>>() {
                });
                produtoRepository.saveAll(mockeProdutos);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
