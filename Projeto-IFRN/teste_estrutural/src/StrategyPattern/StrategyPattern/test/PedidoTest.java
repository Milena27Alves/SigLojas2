import com.exemplo.exception.ItemExistenteException;
import com.exemplo.strategy.*;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PedidoTest {

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
