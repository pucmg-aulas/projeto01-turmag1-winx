/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RequisicoesDAO;
import exception.FormatoInvalidoException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import model.Requisicao;
import view.ListarRequisicaoView;

/**
 *
 * @author imcat
 */
public class ListarRequisicaoController {
    
    private ListarRequisicaoView view;
    private final RequisicoesDAO requisicoes;

    public ListarRequisicaoController() throws FormatoInvalidoException {
    
        this.requisicoes = RequisicoesDAO.getInstance();
        this.view = new ListarRequisicaoView();
        
        carregaTabela();
        
        this.view.setVisible(true);
        
    }
    
    
    private void carregaTabela() throws FormatoInvalidoException{
        Object colunas[] = {"Cliente", "Mesa", "Quantidade de Pessoas", "Total"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        
        System.out.println(requisicoes.getRequisicoes().size());
        
        for(Requisicao requisicao : requisicoes.getRequisicoes()){
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