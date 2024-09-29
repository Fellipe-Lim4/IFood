package ifood.produtos;

public class ItensPedido {
  private String nome;
  private String descricao;
  private double preco;
  private int qtd;
  


  public ItensPedido(String nome, String descricao, double preco) {
	  this.nome = nome;
	  this.descricao = descricao;
	  this.preco = preco;
  }

  public ItensPedido(Produto produto) {
	  this.nome = produto.getNome();
	  this.descricao = produto.getDescricao();
	  this.preco = produto.getPreco();
  }

  public int getQtd() {
	  return qtd;
  }

  public void setQtd(int qtd) {
	  this.qtd = qtd;
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

  @Override
  public String toString() {
	  return "Nome: " + nome + ", Descrição: " + descricao + ", Preço: " + preco;
  }


}