/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Produto;

/**
 *
 * @author letci
 */
public class PedidoDAO extends AbstractDAO {
    
    private List<Pedido> pedidos;
    private String path;
    private ProdutoDAO produtoDAO;
    
    private static PedidoDAO instance;
    
    private PedidoDAO() {
        this.pedidos = new ArrayList<>();
        this.path = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "data", "pedidosDAO.ser").toString();
    }
    
    public static PedidoDAO getInstance() {
        if(instance == null){
            instance = new PedidoDAO();
        }
        return instance;
    }
    
    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        gravar(path, pedidos);
        carregarPedido();
    }
    
     /*public Pedido buscarPedido(String nomeCliente){
        
        // adicionar tratamento de dados
        //ADICIONAR METODO PARA PROCURAR PEDIDO
        for(Pedido pedido : pedidos){
            if (pedido.getClienteNome().equals(nomeCliente)){
                 return pedido;
            }
        }
        return null;
    }*/
    
    public void removerPedido(Pedido pedido){
        this.pedidos.remove(pedido);
        gravar(path, pedidos);   
    }
    
    private void carregarPedido(){
        this.pedidos.addAll(recuperar(path));
    }
    
    /*public Produto buscarPedidoPorNome(String nome){
        
        for (Pedido pedido : getPedidos()) {
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }*/

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
    
    
}
