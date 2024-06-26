/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProdutoDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Produto;
import view.CadastrarProdutoView;

/**
 *
 * @author letci
 */
public class CadastrarProdutoController {
    
    private ProdutoDAO produtoDAO;
    private CadastrarProdutoView view;
    
    
    public CadastrarProdutoController(){
        this.produtoDAO = ProdutoDAO.getInstance();
        this.view = new CadastrarProdutoView();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            cadastrarProduto();
            sair();
        });
        
        this.view.getCancelaBtn().addActionListener((e) -> {
            cancelar();
        });
        
        this.view.setVisible(true);
        
        //adicionar os listeners aqui
        // 
    }
    
    public void cadastrarProduto() {
        
        String nome = view.getNomeProdutoField().getText();
        double preco = Double.parseDouble(view.getPrecoProdutoField().getText()) ;
        int estoque = Integer.parseInt(view.getEstoqueProdutoField().getText());
        
        Produto produto = new Produto(nome, preco,estoque );
        
        produtoDAO.addProduto(produto);
        
        JOptionPane.showMessageDialog(view, "Produto salvo com sucesso!");
        
        limparTela();
    }
        
    public void limparTela(){
        
        this.view.getNomeProdutoField().setText("");
        this.view.getPrecoProdutoField().setText("");
        this.view.getEstoqueProdutoField().setText("");
    }
    
    private void sair() {
        this.view.dispose();
    }
    
     private void cancelar() {
        this.view.dispose();
    }
    
}
