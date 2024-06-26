/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RequisicoesDAO;
import exception.FormatoInvalidoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Requisicao;
import view.ListarPesquisarRequisicaoView;

/**
 *
 * @author imcat
 */
public class ListarPesquisarRequisicaoController {
    
    private final ListarPesquisarRequisicaoView view;
    private final RequisicoesDAO requisicoes;

    public ListarPesquisarRequisicaoController() throws FormatoInvalidoException {
    
        this.requisicoes = RequisicoesDAO.getInstance();
        this.view = new ListarPesquisarRequisicaoView();
        
        carregaTabela(requisicoes.getRequisicoes());
        
        this.view.getBtnPesquisar().addActionListener((e) -> {
            try {
                pesquisarRequisicao();
            } catch (FormatoInvalidoException ex) {
                Logger.getLogger(ListarPesquisarRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
       /** this.view.getTxtCliente().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    pesquisarRequisicao();
                } catch (FormatoInvalidoException ex) {
                    Logger.getLogger(ListarPesquisarRequisicaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });**/
        
        
        this.view.setVisible(true);
        
    }
    
    private void pesquisarRequisicao() throws FormatoInvalidoException{
        
        String nomeCliente = view.getTxtCliente().getText();
        List<Requisicao> requisicoesEncontradas = requisicoes.buscarRequisicao(nomeCliente);
        
        carregaTabela(requisicoesEncontradas);
        
    }
    
    
    private void carregaTabela(List<Requisicao> requisicoes) throws FormatoInvalidoException{
        Object colunas[] = {"Cliente", "Mesa", "Quantidade de Pessoas", "Total"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        
        for(Requisicao requisicao : requisicoes){
            try{
                
                String req = requisicao.toString();
                String[] linha = req.split("%");
                
                 if (linha.length == 4) {
                    // Adicionando a linha na tabela
                    tm.addRow(new Object[]{linha[0], linha[1], linha[2], linha[3]});
                } else {
                    // Lançando exceção personalizada
                    throw new FormatoInvalidoException("Formato de requisicao inválido: " + req);
                }
            
            } catch (ArrayIndexOutOfBoundsException | FormatoInvalidoException e){
                throw new FormatoInvalidoException("Erro ao processar a requisicao: " + e.getMessage());
            }
        }
        
        view.getTbRequisicoes().setModel(tm);
    }
    
}
