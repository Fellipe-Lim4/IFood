package ifood.produtos;

public class Item {
  private String nome;
  private String descricao;
  private double preco;
  

  public Item(String nome, String descricao, double preco) {
    nome = this.nome;
    descricao = this.descricao;
    preco = this.preco;
  }
  
public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String toString() {
    return " Nome: '" + nome + '\n' +
        " Descrição: '" + descricao + "\n" +
        " Preço: " + preco;
  }
}