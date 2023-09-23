package com.petrarca.apicardapio.service.impl;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.petrarca.apicardapio.dto.ProdutoDto;
import com.petrarca.apicardapio.exception.AppException;
import com.petrarca.apicardapio.model.Produto;
import com.petrarca.apicardapio.repository.ProdutoRepository;
import com.petrarca.apicardapio.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private void checkName(final ProdutoDto produtoData) {
        if (produtoRepository.existsByNome(produtoData.getNome())) {
            throw new AppException("Nome de produto já está em uso", HttpStatus.CONFLICT);
        }
    }

    public Produto createProduto(final ProdutoDto produtoData) {
        checkName(produtoData);

        final Produto novoProduto = new Produto();
        novoProduto.setNome(produtoData.getNome());
        novoProduto.setValor(produtoData.getValor());
        novoProduto.setCategoria(produtoData.getCategoria());
        novoProduto.setDescricao(produtoData.getDescricao());

        return produtoRepository.save(novoProduto);
    }

    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    public Produto updateProduto(final ProdutoDto produtoData, final long id) {
        checkName(produtoData);

        final Produto produtoEncontrado = produtoRepository
                .findById(id)
                .orElseThrow(() -> new AppException("Produto não foi encontrado", HttpStatus.NOT_FOUND));

        produtoEncontrado.setNome(produtoData.getNome());
        produtoEncontrado.setValor(produtoData.getValor());
        produtoEncontrado.setCategoria(produtoData.getCategoria());
        produtoEncontrado.setDescricao(produtoData.getDescricao());

        return produtoRepository.save(produtoEncontrado);
    }

    public void deleteProduto(final long id) {
        final Produto produtoEncontrado = produtoRepository.findById(id)
                .orElseThrow(() -> new AppException("Produto não encontrado", HttpStatus.NOT_FOUND));

        produtoRepository.delete(produtoEncontrado);
    }

}
