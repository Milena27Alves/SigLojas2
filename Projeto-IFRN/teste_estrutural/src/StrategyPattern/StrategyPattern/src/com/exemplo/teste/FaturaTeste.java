package com.exemplo.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.exemplo.strategy.Cartao;
import com.exemplo.strategy.Compra;
import com.exemplo.strategy.Fatura;
import com.exemplo.strategy.TipoCartao;

public class FaturaTeste {
	private Compra comp = new Compra("Blusa", 1);
	private Fatura fat = new Fatura();
	
	
	@Test
    public void testAddCompraComSucesso(){
            this.fat.addCompra(comp);
            assertEquals(1, fat.getTotal(), 0.1);
    }
	

}
