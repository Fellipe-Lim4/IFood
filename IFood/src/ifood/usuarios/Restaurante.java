package ifood.usuarios;

import ifood.produtos.Produto;
import ifood.produtos.Produto;
import java.util.List;
import java.util.ArrayList;
import ifood.gerenciadores.GerenciadorRestaurante;

public class Restaurante extends Usuario {
	  private String cnpj;
	  private List<Produto> produtos = new ArrayList<>();
	  private int idRestaurante;
	  
	  public Restaurante(String cnpj, GerenciadorRestaurante gerenciador) {
	    this.cnpj = cnpj;
	    this.setIdRestaurante(gerenciador);
	  }
	  
	  public Produto criaProduto(String nome, String descricao, double preco) {
		  Produto produto = new Produto(nome,descricao,preco);
		  return produto;
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
		if(this.produtos.size()==0) {
			System.out.println("O cardápio está vazio!");
			return;
		}
		System.out.print("\n{");
		int cont = 0;
	    for(Produto produto : this.produtos) {
	    	++cont;
	    	System.out.print(cont + "." + produto.toString() + " // ");
	    }
	    System.out.print("}\n");
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
		int tamanho = gerenciador.getRestaurantes().size();
		this.idRestaurante = tamanho;
	}
	
	@Override
	public String toString() {
		return "Restaurante [cnpj=" + cnpj + ", produtos=" + produtos + ", idRestaurante=" + idRestaurante + "]";
	}
	  
  
}