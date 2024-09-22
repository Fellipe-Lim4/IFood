package ifood.usuarios;

import ifood.produtos.Produto;
import java.util.List;
import java.util.ArrayList;
import ifood.gerenciadores.GerenciadorRestaurante;

public class Restaurante extends Usuario {

	  private String cnpj;
	  private List<Produto> produtos = new ArrayList<>();
	  private int idRestaurante;
	  
	  public Restaurante(String cnpj) {
	    this.cnpj = cnpj;
	  }
	
	  public void adicionaProduto(Produto produto) {
	    this.produtos.add(produto);
	  }
	  public void removeProduto(Produto produto) {
	    this.produtos.remove(produto);
	  }
	  public List<Produto> getProdutos() {
	    return this.produtos;
	  }
	
	  public void exibeProdutos() {
	    for(Produto produto : this.produtos) {
	      System.out.println(produto.toString());
	    }
	  }
	  
	  public String getCnpj() {
	    return cnpj;
	  }
	  public void setCnpj(String cnpj) {
	    this.cnpj = cnpj;
	  }
  

	public int getIdRestaurante() {
		return idRestaurante;
	}
	
	public void setIdRestaurante(GerenciadorRestaurante gerenciador) {
		this.idRestaurante = gerenciador.getRestaurantes().size();
	}
	
	@Override
	public String toString() {
		return "Restaurante [cnpj=" + cnpj + ", produtos=" + produtos + ", idRestaurante=" + idRestaurante + "]";
	}
	  
  
}