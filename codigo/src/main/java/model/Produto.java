/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author letci
 */
public class Produto implements Serializable {
  private String nome;
  private double preco;
  private int estoque;
  private static List<Produto> produtos = new ArrayList<>();
 
  public Produto(String nome, double preco, int estoque) {
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;

  }

  public String getNome() {
    return nome;
}

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getEstoque() {
    return estoque;
  }

  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }
  
  public List<Produto> getProdutos() {
    return produtos;
  }

  public void atualizaEstoque(int quantidade){
      // adicionar bvalidação
    this.estoque += quantidade;
  }
  
  public void diminuiEstoque(int quantidade){
      // adicionar bvalidação
    this.estoque -= quantidade;
  }
  
  public double calculaTotalPedido(int quantidade){
        return getPreco() * quantidade;
    }
  
  @Override
    public String toString() {
        return nome + "%" + preco + "%" + estoque;
    }

}