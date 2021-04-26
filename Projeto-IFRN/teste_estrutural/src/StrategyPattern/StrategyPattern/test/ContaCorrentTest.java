import com.exemplo.exception.SaldoInsuficienteException;
import com.exemplo.strategy.Cliente;
import com.exemplo.strategy.ContaCorrente;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContaCorrentTest {

    private ContaCorrente cc = new ContaCorrente("111");
    private Cliente cliente = new Cliente("Alberto", "1234");

    @Before
    public void setUp(){
        this.cliente.setContaCorrente(cc);
        this.cc.setCliente(cliente);
        this.cc.setSaldo(50.0);
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

}
