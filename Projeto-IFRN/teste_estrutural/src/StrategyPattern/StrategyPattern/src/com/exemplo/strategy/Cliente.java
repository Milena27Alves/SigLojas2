package com.exemplo.strategy;

import com.exemplo.strategy.ContaCorrente;

public class Cliente {

    private String nome;
    private String cpf;
    private ContaCorrente contaCorrente;
    private Cartao cartao;

    public Cliente(String n, String cpf){
        this.nome = n;
        this.cpf = cpf;
    }

    public ContaCorrente getContaCorrente() {
        return this.contaCorrente;
    }

    public Cartao getCartao() {
        return this.cartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
        contaCorrente.setCliente(this);
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
