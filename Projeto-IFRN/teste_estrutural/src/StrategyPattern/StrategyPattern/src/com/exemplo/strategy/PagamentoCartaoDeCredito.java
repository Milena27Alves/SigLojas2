package com.exemplo.strategy;

public class PagamentoCartaoDeCredito implements PagamentoStrategy {

    private Compra compra;

    public PagamentoCartaoDeCredito() {
    }

    @Override
    public void pagar(Pedido pedido) {
        compra = new Compra(pedido.getDescricao(), pedido.getPrecoTotal());
        pedido.getCliente().getCartao().acrescentarNaFatura(compra);
    }

    public Compra getCompra(){
        return this.compra;
    }
}
