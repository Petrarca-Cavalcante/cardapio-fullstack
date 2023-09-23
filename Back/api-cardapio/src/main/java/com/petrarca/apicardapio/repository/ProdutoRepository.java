package com.petrarca.apicardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petrarca.apicardapio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    boolean existsByNome(final String nome);

}
