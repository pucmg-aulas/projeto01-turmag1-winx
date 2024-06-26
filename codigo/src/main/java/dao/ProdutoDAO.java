/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author letci
 */
public class ProdutoDAO extends AbstractDAO {
    
     private List<Produto> produtos;
     private static ProdutoDAO instance;
     private String path;
     

    private ProdutoDAO() {
        this.produtos = new ArrayList<>();
        this.path = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "data", "produtosDAO.ser").toString();
    }
    
    public static ProdutoDAO getInstance() {
        if(instance == null){
            instance = new ProdutoDAO();
        }
        return instance;
    }
         
    public Produto buscarProdutoPorNome(String nome){
        
        for (Produto produto : this.getProdutos()) {
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }
    
         
     public void addProduto(Produto produto){
         this.produtos.add(produto);
         gravar(path, produtos);
        carregarProduto();
     }
    
        private void carregarProduto(){
        this.produtos.addAll(recuperar(path));
    }
    
     public void removerProduto(Produto produto){
        this.produtos.remove(produto);
        gravar(path, produtos);   
    }     
     
    public List<Produto> getProdutos() {
        return produtos;
     }
     
   
}
