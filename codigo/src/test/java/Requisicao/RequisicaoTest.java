/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Requisicao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import restaurante.Bebida;
import model.ClienteModel;
import restaurante.Mesa;
import restaurante.Pedido;
import restaurante.Produto;
import restaurante.Requisicao;

/**
 *
 * @author imcat
 */
public class RequisicaoTest {
    
    public RequisicaoTest() {
       

    }
    
    private ClienteModel cliente;
    private Requisicao requisicao;
    private List<Requisicao> listasRequisicoes;
    private List<Requisicao> listasEspera;

    @BeforeEach
    public void setUp() {
        cliente = new ClienteModel("John Doe", "000.000.000-00");
        requisicao = new Requisicao(LocalDateTime.now(), 2, cliente);
        listasRequisicoes = new ArrayList<>();
        listasEspera = new ArrayList<>();
    }

    @Test
    public void testAdicionarPedidoNoVetor() {
        Produto produto = new Bebida("Água", 4.00, 20);
        Pedido pedido = new Pedido(8.00, produto, 2);
        requisicao.adicionarPedidoNoVetor(pedido);

        assertTrue(requisicao.getListaPedidos().contains(pedido));
    }

    @Test
    public void testCalcularTotalComTaxa() {
        Produto produto = new Bebida("Água", 4.00, 20);
        Pedido pedido = new Pedido(8.00, produto, 2);
        //Pedido pedido = new Pedido(8.00, requisicao, produto, 2);
        requisicao.adicionarPedidoNoVetor(pedido);
        double expected = 8.00 * 1.1; // 10% service charge
        assertEquals(expected, requisicao.calculaTotalComTaxa(), 0.01);
    }

    @Test
    public void testPesquisarRequisicao() {
        List<Requisicao> listasRequisicoes = new ArrayList<>();
        listasRequisicoes.add(requisicao);

        Requisicao encontrada = listasRequisicoes.stream()
                .filter(r -> r.getClienteNome().equals(cliente.getNome()))
                .findFirst()
                .orElse(null);

        assertNotNull(encontrada);
    }
    
    @Test
    public void testAdicionarNaListaDeEspera() {
        listasEspera.add(requisicao);
        assertTrue(listasEspera.contains(requisicao));
    }
    
    @Test
    public void testDecidirDestinoDaRequisicao() {
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(4, false));
        mesas.add(new Mesa(6, false));
        mesas.add(new Mesa(8, false));

        Mesa mesaDisponivel = mesas.stream()
                .filter(m -> !m.getOcupado() && m.verificaCapacidade(requisicao.getQuantPessoas()))
                .findFirst()
                .orElse(null);

        if (mesaDisponivel != null) {
            requisicao.alocarMesa(mesaDisponivel);
            listasRequisicoes.add(requisicao);
            assertTrue(requisicao.getMesa() != null);
        } else {
            listasEspera.add(requisicao);
            assertTrue(listasEspera.contains(requisicao));
        }
    }
      
        
    
    
//    @Test
  //  public void testCalculaTotalComTaxa() {
    //    Cliente cliente = new Cliente("John Doe", "000.000.000-00");
      //  Requisicao requisicao = new Requisicao(LocalDateTime.now(), 2, cliente);
        //Produto produto = new Bebida("Água", 4.00, 20);
       // Pedido pedido = new Pedido(8.00, requisicao, produto, 2);
        //requisicao.adicionarPedidoNoVetor(pedido);

       // double expected = 8.00 * 1.1; // 10% service charge
       // assertEquals(expected, requisicao.calculaTotalComTaxa(), 0.01);
   // }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
