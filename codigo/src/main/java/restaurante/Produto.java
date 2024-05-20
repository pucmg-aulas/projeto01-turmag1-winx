package restaurante;
public abstract class Produto {
  private String nome;
  private double preco;
  private int estoque;
 
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

  public void atualizaEstoque(int quantidade){
      // adicionar bvalidação
    this.estoque += quantidade;
  }

}