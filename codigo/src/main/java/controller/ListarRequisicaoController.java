/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Requisicoes;
import java.util.Iterator;
import model.Requisicao;
import view.ListarRequisicaoView;

/**
 *
 * @author imcat
 */
public class ListarRequisicaoController {
    
     private ListarRequisicaoView view;
    private Requisicoes requisicoes;

    public ListarRequisicaoController() {
    
        this.requisicoes = Requisicoes.getInstance();
        this.view = new ListarRequisicaoView();
        
        carregaTabela();
        
        this.view.getBtnExcluir().addActionListener((e) -> {
            excluirCarro();
        });
        
        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });
        
        this.view.getBtnEditar().addActionListener((e) -> {
            editar();
        });
        
        this.view.setVisible(true);
        
    }
    
    private void sair() {
        this.view.dispose();
    }
    
    private void carregaTabela(){
        Object colunas[] = {"Nome", "Marca"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        Iterator<Requisicao> req = requisicoes.getRequisicoes().iterator();
        while (req.hasNext()) {
            Requisicao requisicao = req.next();
            String reqString = requisicao.toString();
            String linha[] = reqString.split("%");
            tm.addRow(new Object[]{linha[0], linha[1]});
        }
        view.getTbCarros().setModel(tm);
    }
    
}
