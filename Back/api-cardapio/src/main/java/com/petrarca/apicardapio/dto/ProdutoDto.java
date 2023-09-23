package com.petrarca.apicardapio.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoDto {

    @NotEmpty(message = "Nome do produto é obrigatório")
    @Size(max = 25, message = "Nome pode ter até 25 caracteres")
    private String nome;

    @NotNull(message = "Valor do produto é obrigatório")
    @DecimalMin(value = "1.0", message = "Preço deve ser maior que 1")
    private float valor;

    @NotEmpty(message = "Categoria do produto não pode ser nula")
    @Size(max = 15, message = "Categoria pode ter até 15 caracteres")
    private String categoria;

    @Size(max = 180)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
