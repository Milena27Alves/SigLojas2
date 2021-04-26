package com.exemplo.strategy;

import com.exemplo.exception.ItemExistenteException;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Caderno", 20.0);
        Item item2 = new Item("Canetas", 10.0);
        Item item3 = new Item("Mochila", 50.0);

        Cliente cliente1 = new Cliente("Fausto", "11111");
        ContaCorrente cc1 = new ContaCorrente("123");
        cliente1.setContaCorrente(cc1);
        cc1.setSaldo(100);
        Cartao ct1 =  new Cartao("44321", TipoCartao.CREDITO);
        cliente1.setCartao(ct1);
        ct1.setProprietario(cliente1);

        Cliente cliente2 = new Cliente("Silvia", "11111");
        ContaCorrente cc2 = new ContaCorrente("123");
        cliente2.setContaCorrente(cc2);
        cc2.setSaldo(100);
        Cartao ct2 =  new Cartao("44321", TipoCartao.CREDITO);
        cliente2.setCartao(ct2);
        ct2.setProprietario(cliente2);

        Pedido p1 = new Pedido(cliente1,"Material escolar");

        Pedido p2 = new Pedido(cliente2,"Material escolar");

        try {
            p1.addItem(item1);
            p1.addItem(item2);

            p2.addItem(item3);
            p2.addItem(item1);


            System.out.println("Pedido 1 pago no cartão de crédito");
            p1.realizarPedido(new PagamentoCartaoDeCredito());

            System.out.println("\n\nPedido 2 pago no débito");
            p2.realizarPedido(new PagamentoEmDebito());
        } catch (ItemExistenteException e) {
            System.out.println(e.getMessage());
        }

    }
}
