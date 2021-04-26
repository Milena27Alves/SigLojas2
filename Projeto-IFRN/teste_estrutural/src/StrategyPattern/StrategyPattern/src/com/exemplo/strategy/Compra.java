package com.exemplo.strategy;

public class Compra {
    private String descricao;
    private double quantia;

    public Compra(String descricao, double quantia) {
        this.descricao = descricao;
        this.quantia = quantia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantia() {
        return quantia;
    }

    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }
}
