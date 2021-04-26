package com.exemplo.strategy;

import com.exemplo.exception.SaldoInsuficienteException;

public class PagamentoEmDebito implements PagamentoStrategy{

    public PagamentoEmDebito() {
    }

    @Override
    public void pagar(Pedido pedido){
        try {
            pedido.getCliente().getContaCorrente().debitar(pedido.getPrecoTotal());
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}
