package com.petrarca.apicardapio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petrarca.apicardapio.dto.ProdutoDto;
import com.petrarca.apicardapio.model.Produto;
import com.petrarca.apicardapio.service.ProdutoService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody final ProdutoDto produtoData) {

        final Produto produtoCriado = produtoService.createProduto(produtoData);

        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        final List<Produto> todosProdutos = produtoService.listProdutos();

        return new ResponseEntity<>(todosProdutos, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@Valid @RequestBody final ProdutoDto produtoData,
            @PathVariable final String id) {
        final Produto produtoAtualizado = produtoService.updateProduto(produtoData, Long.parseLong(id));

        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable final String id) {
        produtoService.deleteProduto(Long.parseLong(id));
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
