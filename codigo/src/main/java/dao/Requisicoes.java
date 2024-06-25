/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Requisicao;

/**
 *
 * @author imcat
 */
public class Requisicoes extends AbstractDAO {
    
    private List<Requisicao> requisicoes;
    private String path;
    
    private static Requisicoes instance;
    
    private Requisicoes() {
        this.requisicoes = new ArrayList<>();
        this.path = ".src/main/java/data/requisicoes.ser";
    }
    
    public static Requisicoes getInstance(){
        if(instance == null){
            instance = new Requisicoes();
        }
        return instance;
    }
    
    public void addRequisicao(Requisicao requisicao){
        this.requisicoes.add(requisicao);
        gravar(path, requisicoes);
        carregarRequisicoes();
    }
    
    public Requisicao buscarRequisicao(String nomeCliente){
        
        // adicionar tratamento de dados
        for(Requisicao requisicao : requisicoes){
            if (requisicao.getClienteNome().equals(nomeCliente)){
                 return requisicao;
            }
        }
        return null;
    }
    
    public void removerRequisicao(Requisicao requisicao){
        this.requisicoes.remove(requisicao);
        gravar(path, requisicoes);   
    }
    
    private void carregarRequisicoes(){
        this.requisicoes.addAll(recuperar(path));
    }

}