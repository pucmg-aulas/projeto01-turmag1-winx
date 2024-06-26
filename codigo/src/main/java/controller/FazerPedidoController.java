/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import model.Produto;
import model.Requisicao;
import view.FazerPedidoView;

/**
 *
 * @author letci
 */
public class FazerPedidoController {


    
    private PedidoDAO pedidoDAO;
    private ProdutoDAO produtoDAO;
    private FazerPedidoView view;
    private Requisicao requisicao;
    
    public FazerPedidoController() {
        this.view = new FazerPedidoView();
        this.pedidoDAO = PedidoDAO.getInstance();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        carregaTabela();
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            fazerPedido();
        });
        
        this.view.getCancelaBtn().addActionListener((e) -> {
            //cancelar();
        });
        
        this.view.setVisible(true);
    }
    
    
    
    
    private void carregaTabela(){
        Object colunas[] = {"Nome", "Preco", "Estoque"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        Iterator<Produto> it = produtoDAO.getProdutos().iterator();
        while (it.hasNext()) {
            Produto c = it.next();
            String produto = c.toString();
            String linha[] = produto.split("%");
            tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getTbProdutos().setModel(tm);
    }
    
    public void fazerPedido() {
               
       int quantProduto =  Integer.parseInt(view.getQuantProdutoField().getText());
       
       //Pedido p = new Pedido(calculaTotalPedido(produtoPedido, quantidade), produtoPedido, quantidade);
       
       if(view.getTbProdutos().getSelectedRow() != -1){
            
            int linha = this.view.getTbProdutos().getSelectedRow();
            String nome = (String) this.view.getTbProdutos().getValueAt(linha, 0);
            
            int op = JOptionPane.showConfirmDialog(view, "Selecionar " + nome + "?");
            if(op == JOptionPane.YES_OPTION){
                Produto produtoEscolhido = produtoDAO.buscarProdutoPorNome(nome);
                
                /*produtoDAO.removerProduto(produto);
                JOptionPane.showMessageDialog(view, nome + " Excluído com Sucesso!");
                */
                
                Pedido p = new Pedido(calculaTotalPedido(produtoEscolhido, quantProduto), produtoEscolhido, quantProduto);
                requisicao.adicionarPedidoNoVetor(p);
                
                
                carregaTabela();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
       
       
    }
    
    
    private double calculaTotalPedido(Produto produto, int quantidade){
        return produto.getPreco() * (double)quantidade;
    }
    
    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public FazerPedidoView getView() {
        return view;
    }

    public void setView(FazerPedidoView view) {
        this.view = view;
    }
}
