package com.exemplo.strategy;

import java.util.LinkedList;
import java.util.List;

public class Fatura {
    private double total;
    private List<Compra> compras;

    public Fatura(){
        this.total = 0;
        this.compras = new LinkedList<>();
    }

    public void addCompra(Compra compra){
        this.compras.add(compra);
        this.setTotal(compra.getQuantia());
    }

    public double getTotal(){
        return this.total;
    }

    public void setTotal(double quantiaDaCompra) {
        this.total += quantiaDaCompra;
    }

    public void exibirFatura(){
        System.out.println("=======FATURA======\n" +
                "[Descrição]: [Quantia]");
        for (Compra compra: this.compras){
            System.out.println(compra.getDescricao()+": " + compra.getQuantia());
        }
        System.out.println("TOTAL DA FATURA: " + this.getTotal());
    }

    public List<Compra> getCompras() {
        return this.compras;
    }
}
