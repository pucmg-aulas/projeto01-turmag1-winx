/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import view.FazerPedidoView;

/**
 *
 * @author letci
 */
public class FazerPedidoController {
    
    private PedidoDAO pedidoDAO;
    private ProdutoDAO produtoDAO;
    private FazerPedidoView view;
    
    public FazerPedidoController() {
        this.view = new FazerPedidoView();
        this.pedidoDAO = PedidoDAO.getInstance();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        carregaTabela();
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            fazerPedido();
        });
        
        this.view.getCancelaBtn().addActionListener((e) -> {
            cancelar();
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
        
       int idProduto =  Integer.parseInt(view.getgetIdProdutoField().getText());
       
       int quantProduto =  Integer.parseInt(view.getQuantProdutoField().getText());
    }
}
