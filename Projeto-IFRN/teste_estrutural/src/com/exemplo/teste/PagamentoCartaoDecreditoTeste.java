package com.exemplo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.exemplo.exception.ItemExistenteException;
import com.exemplo.strategy.Cartao;
import com.exemplo.strategy.Cliente;
import com.exemplo.strategy.ContaCorrente;
import com.exemplo.strategy.Item;
import com.exemplo.strategy.PagamentoCartaoDeCredito;
import com.exemplo.strategy.PagamentoEmDebito;
import com.exemplo.strategy.Pedido;
import com.exemplo.strategy.TipoCartao;

public class PagamentoCartaoDecreditoTeste {
	
	 Cliente cliente = new Cliente("Luis", "43241");
	    Pedido pedido = new Pedido(cliente, "Livros");
	    Item livro, livro2;
	    Cartao cartao = new Cartao("123", TipoCartao.CREDITO);
	    private ContaCorrente cc = new ContaCorrente("111");

	    @Before
	    public void setUp(){
	        livro = new Item("1984", 45.0);
	        cliente.setCartao(cartao);
	        cartao.setProprietario(cliente);
	        
	        this.cliente.setContaCorrente(cc);
	        this.cc.setCliente(cliente);
	        this.cc.setSaldo(50.0);
	    }
	    
	    @Test
	    public void testPagarComSucesso(){
	    	
	        try {
	            this.pedido.addItem(this.livro);
	        } catch (ItemExistenteException ex){
	            System.out.println(ex.getMessage());
	        }
	        PagamentoCartaoDeCredito pgto = new PagamentoCartaoDeCredito();
	        pgto.pagar(pedido);
	        assertEquals(livro.getPreco(), pedido.getCliente().getCartao().getFatura().getTotal(), 0.1);  
	    }

}
