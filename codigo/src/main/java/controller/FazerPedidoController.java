/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PedidoDAO;
import dao.ProdutoDAO;
import exception.FormatoInvalidoException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this.produtoDAO = ProdutoDAO.getInstance();
        
        try{
            carregaTabela();
        }catch(FormatoInvalidoException e){
            System.out.println("message: " + e.getMessage());
        }
        
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            try {
                fazerPedido();
            } catch (FormatoInvalidoException ex) {
                Logger.getLogger(FazerPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        this.view.getCancelaBtn().addActionListener((e) -> {
            cancelar();
        });
        
        this.view.setVisible(true);
    }
    
    
    
    
    private void carregaTabela() throws FormatoInvalidoException{
        Object colunas[] = {"Nome", "Preco", "Estoque"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        
        System.out.println(produtoDAO.getProdutos().size());
        
        for(Produto produto: produtoDAO.getProdutos()){
            try{
                
                String prod = produto.toString();
                String[] linha = prod.split("%");
                
                 if (linha.length == 4) {
                    // Adicionando a linha na tabela
                    tm.addRow(new Object[]{linha[0], linha[1], linha[2], linha[3]});
                } else {
                    // Lançando exceção personalizada
                    throw new FormatoInvalidoException("Formato de requisicao inválido: " + prod);
                }
            
            } catch (ArrayIndexOutOfBoundsException | FormatoInvalidoException e){
                throw new FormatoInvalidoException("Erro ao processar a requisicao: " + e.getMessage());
            }
        }
        
        view.getTbProdutos().setModel(tm);
    }
    
    public void fazerPedido() throws FormatoInvalidoException{
               
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
    
     private void sair() {
        this.view.dispose();
    }
    
     private void cancelar() {
        this.view.dispose();
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
