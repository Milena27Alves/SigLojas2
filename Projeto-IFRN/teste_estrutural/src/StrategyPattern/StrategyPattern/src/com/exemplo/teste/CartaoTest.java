package StrategyPattern.StrategyPattern.src.com.exemplo.teste;

import com.exemplo.exception.SaldoInsuficienteException;
import com.exemplo.strategy.Cartao;
import com.exemplo.strategy.Cliente;
import com.exemplo.strategy.Compra;
import com.exemplo.strategy.ContaCorrente;
import com.exemplo.strategy.TipoCartao;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CartaoTest {
	
	private Cartao c = new Cartao("1234", TipoCartao.DEBITO);
	private Compra comp = new Compra("Blusa", 1);
	
	
	@Test
    public void testAcrescentarNaFaturaComSucesso(){
            this.c.acrescentarNaFatura(comp);
            assertEquals(1, c.getFatura().getTotal(), 0.1);
    }
	
	@Test
    public void testconsultarFaturaComSucesso(){
			this.c.consultarFatura();
            assertEquals(0, c.getFatura().getTotal(), 0.1);
    }

	

}
