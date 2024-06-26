/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Requisicao;

/**
 *
 * @author imcat
 */
public class RequisicaoDAO extends AbstractDAO {
    
    private List<Requisicao> requisicoes;
    private String path;
    
    private static RequisicaoDAO instance;
    
    private RequisicaoDAO() {
        this.requisicoes = new ArrayList<>();
        this.path = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "data", "requisicaoDAO.ser").toString();
    }
    
    public static RequisicaoDAO getInstance(){
        if(instance == null){
            instance = new RequisicaoDAO();
        }
        return instance;
    }
    
    public void addRequisicao(Requisicao requisicao){
        this.requisicoes.add(requisicao);
        gravar(path, requisicoes);
        getRequisicoes();
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
    
    public void getRequisicoes(){
        this.requisicoes.addAll(recuperar(path));
    }

}
