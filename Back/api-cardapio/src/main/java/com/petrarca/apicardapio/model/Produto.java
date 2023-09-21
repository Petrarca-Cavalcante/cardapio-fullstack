package com.petrarca.apicardapio.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(length = 25, nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    @Column(length = 15, nullable = false)
    private String categoria;

    @Column(length = 180)
    private String descricao;

    @CreationTimestamp()
    @Column(updatable = false)
    private Date criadoEm;

    public Produto() {
    }

    public Produto(String nome, float valor, String categoria, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public float getValor(){
        return valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }
    
    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
