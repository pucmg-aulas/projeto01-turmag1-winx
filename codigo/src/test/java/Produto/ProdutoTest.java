/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Produto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import restaurante.Bebida;
import restaurante.Prato;
import restaurante.Produto;

/**
 *
 * @author imcat
 */
public class ProdutoTest {
    
    public ProdutoTest() {
    }
    
    private List<Produto> produtos;

    @BeforeEach
    public void setUp() {
        produtos = new ArrayList<>();
        produtos.add(new Bebida("Água", 4.00, 20));
        produtos.add(new Prato("Moqueca de Tilápia", 59.00, 20));
    }

    @Test
    public void testAdicionarProduto() {
        Produto novoProduto = new Bebida("Cerveja", 12.00, 20);
        produtos.add(novoProduto);
        assertTrue(produtos.contains(novoProduto));
    }

    @Test
    public void testAtualizarEstoque() {
        Produto produto = produtos.get(0);
        produto.atualizaEstoque(-5);
        assertEquals(15, produto.getEstoque());
    }

    @Test
    public void testVerificaEstoque() {
        Produto produto = produtos.get(0);
        assertTrue(produto.getEstoque() >= 5);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
