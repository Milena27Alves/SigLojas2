package com.exemplo.teste;

import com.exemplo.exception.SaldoInsuficienteException;
import com.exemplo.strategy.Cliente;
import com.exemplo.strategy.ContaCorrente;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContaCorrentTeste {

    private ContaCorrente cc = new ContaCorrente("111");
    private Cliente cliente = new Cliente("Alberto", "1234");
    
    private ContaCorrente c2 = new ContaCorrente("222");
    private Cliente cliente2 = new Cliente("José", "2727");

    @Before
    public void setUp(){
        this.cliente.setContaCorrente(cc);
        this.cc.setCliente(cliente);
        this.cc.setSaldo(50.0);
        
        this.cliente2.setContaCorrente(c2);
        this.c2.setCliente(cliente2);
    }
    
    @Test
    public void testDebitarComSucesso(){
        try {
            this.cc.debitar(30);
        }catch (SaldoInsuficienteException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(20, this.cc.getSaldo(), 0.1);
    }

    @Test
    public void testDebitarComFalha(){
        try {
            this.cc.debitar(60);
            fail("Teste não falhou!");
        }catch (SaldoInsuficienteException ex){
            assertThat(ex.getMessage(), is("Saldo insuficiente!"));
        }
    }
    
    @Test
    public void testCreditarComSucesso(){
        this.cc.creditar(200);
        double atual = cc.getSaldo();
        assertEquals(250,atual, 0.1);
    }
    
    @Test
    public void testTranferirComSucesso(){
    	try {
    		 this.cc.transferir(c2, 30);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
        assertEquals(20,cc.getSaldo(), 0.1);
    }
    
    @Test
    public void testTranferirComFalha(){
        try {
        	this.cc.transferir(c2, 100);
            fail();
        }catch (SaldoInsuficienteException ex){
        	assertThat(ex.getMessage(), is("Saldo insuficiente para a transferência!"));
        }
    }
 
}