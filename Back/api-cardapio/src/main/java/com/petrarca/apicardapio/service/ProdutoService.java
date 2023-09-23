package com.petrarca.apicardapio.service;

import com.petrarca.apicardapio.dto.ProdutoDto;
import com.petrarca.apicardapio.model.Produto;
import java.util.List;

public interface ProdutoService {
 
    Produto createProduto(final ProdutoDto produtoData);

    List<Produto> listProdutos();

    Produto updateProduto(final ProdutoDto produtoData, final long id);

    void deleteProduto(final long id);

}
