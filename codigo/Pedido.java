import java.util.ArrayList;

public class Pedido {

  private double total;
  private Requisicao requisicao;
  private Produto produto;
  private int quantidade;

  public Pedido(double total, Requisicao requisicao, Produto produto, int quantidade) {
    this.total = total;
    this.requisicao = requisicao;
    this.produto = produto;
    this.quantidade = quantidade;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Requisicao getRequisicao() {
    return requisicao;
  }

  public void setRequisicao(Requisicao requisicao) {
    this.requisicao = requisicao;
  }

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
