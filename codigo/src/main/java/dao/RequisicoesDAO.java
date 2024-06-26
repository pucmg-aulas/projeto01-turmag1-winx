/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Requisicao;

/**
 *
 * @author imcat
 */


public class RequisicoesDAO extends AbstractDAO {
    
    private List<Requisicao> requisicoes;
    
    //Endereço do arquivo serializado que contém a coleção de carros
    private String path;
    
    // Atributo da própria classe, estático, para implementar o Singleton
    private static RequisicoesDAO instance;
    
    private RequisicoesDAO() {
        this.requisicoes = new ArrayList<>();
        this.path = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "data", "requisicoes.ser").toString();
        carregaRequisicoes();
    }
    
    public static RequisicoesDAO getInstance(){
        if(instance == null){
            instance = new RequisicoesDAO();
        }
        
        return instance;
    }
    
    private void carregaRequisicoes(){
        this.requisicoes = super.leitura(path);
    }
    
    public void addRequisicao(Requisicao requisicao){
        this.requisicoes.add(requisicao);
        gravar(path, requisicoes);
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
    
    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }
}
