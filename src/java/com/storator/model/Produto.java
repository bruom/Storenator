/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storator.model;

import java.io.Serializable;

/**
 *
 * @author Bruom
 */
public class Produto implements Serializable {

    private String nome;
    private int cod;
    private double preco;
    private String img;
    private String descricao;
    private int estoque;
    private int categoria;

    public Produto(int cod, String nome, String descricao, double preco, int categoria, int estoque, String img) {
        this.nome = nome;
        this.cod = cod;
        this.preco = preco;
        this.img = img;
        this.descricao = descricao;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
