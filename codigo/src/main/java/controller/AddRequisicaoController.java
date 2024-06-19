/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Requisicoes;
import view.AddRequisicaoView;

/**
 *
 * @author imcat
 */
public class AddRequisicaoController {
    private Requisicoes requisicoes;
    private AddRequisicaoView view;
    
    
    
    public AddRequisicaoController(){
        this.view = new AddRequisicaoView();
        this.requisicoes = Requisicoes.getInstance();
        
        //adicionar os listeners aqui
        // 
    }
    
    public void addRequisicao(){
        //pegar os dados dos campos da view
        // int quantPessoas = Integer.valueOf(view.getTxtQuantidadePessoas);
        // após pegar, adicionar no model
        // Requisicao r = new Requisicao(quantPessoas);
        // devemos fazer tratamento de exceção
        // controller comunica a model com o dao
        // 
    }
    
    
}
