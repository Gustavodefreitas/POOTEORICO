package com.example.pedidos.model;

import java.util.Date;

public class Pedido {

    private int codigo;
    private int valor;
    private String descricao;
    private String cliente;
    private Date datadopedido;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String nome) {
        this.cliente = nome;
    }

    public Date getDatadopedido() {
        return datadopedido;
    }

    public void setDatadopedido(Date datadopedido) {
        this.datadopedido = datadopedido;
    }

    @Override
    public String toString() {
        return "Pedido [codigo=" + codigo + ", datadopedido=" + datadopedido + ", descricao=" + descricao + ", nome="
                + cliente + ", valor=" + valor + "]";
    }



    /*
    1. Criar um repositório privado no GitHub para esse projeto.

2. Compartilhar o repositório com o professor( glauco.todesco@gmail.com)

3. Esse projeto tem somente um modelo: Pedido.java

Um pedido possui os seguintes atributos: codigo, valor, descricao, cliente e data do pedido.
4. Desenvolver uma aplicação SpringBoot (rest) do zero que:

Permita cadastrar um novo pedido. O código do pedido deve ser único.
Permita listar todos os pedidos.
Permita pesquisar um pedido pelo código.
Permita remover um pedido
Permita alterar um pedido.
    */
    
}
