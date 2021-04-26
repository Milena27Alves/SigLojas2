package com.exemplo.teste;

import com.exemplo.exception.ItemExistenteException;
import com.exemplo.exception.ListaVaziaException;
import com.exemplo.exception.SaldoInsuficienteException;
import com.exemplo.strategy.*;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PedidoTeste {

    Cliente cliente = new Cliente("Luis", "43241");
    Pedido pedido = new Pedido(cliente, "Livros");
    Item livro;
    Cartao cartao = new Cartao("123", TipoCartao.CREDITO);

    @Before
    public void setUp(){
        livro = new Item("1984", 45.0);
        cliente.setCartao(cartao);
        cartao.setProprietario(cliente);
    }

    
    @Test
    public void testAddItemComSucesso(){
        try {
            this.pedido.addItem(this.livro);
        } catch (ItemExistenteException ex){
            System.out.println(ex.getMessage());
        }
        double resultadoEsperado = pedido.getPrecoTotal();
        double atual = livro.getPreco();
        assertEquals(resultadoEsperado, atual, 0.1);
    }
    

    @Test
    public void testAddComFalha(){
    	
    	 try {
             this.pedido.addItem(this.livro);
             this.pedido.addItem(this.livro);
             fail();
         } catch (ItemExistenteException ex){
        	 assertThat(ex.getMessage(), is("O item já foi adicionado na lista!"));
         }
    }
    
    @Test
    public void testRemoverItemComSucesso(){
        try {
        	this.pedido.addItem(this.livro);
            this.pedido.removerItem(this.livro);
        } catch (ListaVaziaException e) {
        	System.out.println(e.getMessage());
		} catch (ItemExistenteException e) {
			System.out.println(e.getMessage());
		}
        
    }
    
    @Test
    public void testRemoverItemComFalha(){
        try {
            this.pedido.removerItem(this.livro);
            fail();
        } catch (ListaVaziaException e) {
        	assertThat(e.getMessage(), is("Lista vazia!"));
		}
        
    }
    
    @Test
    public void testRealizarPagamentoComSucesso(){
        try {
            this.pedido.addItem(this.livro);
        } catch (ItemExistenteException ex){
            System.out.println(ex.getMessage());
        }
        PagamentoCartaoDeCredito pgto = new PagamentoCartaoDeCredito();
        pedido.realizarPedido(pgto);
        double resultadoEsperado = pedido.getPrecoTotal();
        assertEquals(resultadoEsperado, livro.getPreco(), 0.1);
    }
    
   

}
