/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PedidoDAO;
import dao.ProdutoDAO;
import exception.FormatoInvalidoException;
import java.util.List;
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
    
    public FazerPedidoController(Requisicao requisicao) throws FormatoInvalidoException {
        this.view = new FazerPedidoView();
        this.pedidoDAO = PedidoDAO.getInstance();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.produtoDAO = ProdutoDAO.getInstance();
        
        this.requisicao = requisicao;
        
        carregaTabelaDeProdutos();
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            try {
                fazerPedido();
            } catch (FormatoInvalidoException ex) {
                Logger.getLogger(FazerPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        this.view.getCancelaBtn().addActionListener((e) -> {
            //cancelar();
        });
        
        this.view.setVisible(true);
    }
    
    
    private void carregaTabelaDeProdutos() throws FormatoInvalidoException{
        Object colunas[] = {"Nome", "Preço", "Estoque"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        
        for(Produto produto : produtoDAO.getProdutos()){
            try{
                String prod = produto.toString();
                String linha[] = prod.split("%");
                
                 if (linha.length == 3) {
                    // Adicionando a linha na tabela
                    tm.addRow(new Object[]{linha[0], linha[1], linha[2]});
                } else {
                    // Lançando exceção personalizada
                    throw new FormatoInvalidoException("Formato de requisicao inválido: " + prod);
                }
            }catch(ArrayIndexOutOfBoundsException | FormatoInvalidoException e){
             throw new FormatoInvalidoException("Erro ao processar o pedido: " + e.getMessage());
            }
            
        }
        
        view.getTbProdutos().setModel(tm);
    }
    
    
    
    public void fazerPedido() throws FormatoInvalidoException {
               
       int quantProduto =  Integer.parseInt(view.getQuantProdutoField().getText());
       
       //Pedido p = new Pedido(calculaTotalPedido(produtoPedido, quantidade), produtoPedido, quantidade)
       
        if(view.getTbProdutos().getSelectedRow() != -1){
            
            int linha = this.view.getTbProdutos().getSelectedRow();
            String nome = (String) this.view.getTbProdutos().getValueAt(linha, 0);
            
            int op = JOptionPane.showConfirmDialog(view, "Deseja confirmar a escolha do " + nome + "?");
            if(op == JOptionPane.YES_OPTION){
                Produto produto = produtoDAO.buscarProduto(nome);
                Pedido pedido = new Pedido(produto.calculaTotalPedido(quantProduto), produto, quantProduto, requisicao);
                
                if(produto.getEstoque() >= quantProduto){
                    produto.setEstoque(produto.getEstoque() - quantProduto);
                    
                }else if(produto.getEstoque() == 0){
                    produtoDAO.removerProduto(produto);
                }
//                JOptionPane.showMessageDialog(view, nome + " Excluído com Sucesso!");
//                carregaTabela();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
       
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
