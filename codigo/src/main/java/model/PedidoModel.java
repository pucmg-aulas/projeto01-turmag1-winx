/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import restaurante.Produto;

/**
 *
 * @author thiag
 */
public class PedidoModel {
  private double total; //retirar a necessidade desse atributo
  //private Requisicao requisicao;
  private Produto produto;
  private int quantidade;

  public PedidoModel(double total, Produto produto, int quantidade) {
    this.total = total;
    //this.requisicao = requisicao;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total; //calcular o total do pedido aqui
  }

  /**
  public Requisicao getRequisicao() {
    return requisicao;
  }

  public void setRequisicao(Requisicao requisicao) {
    this.requisicao = requisicao;
  }
  **/

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}
