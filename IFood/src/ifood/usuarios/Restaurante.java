package ifood.usuarios;

import ifood.produtos.Produto;
import java.util.List;
import java.util.ArrayList;
import ifood.gerenciadores.GerenciadorRestaurante;
import java.util.Random;

public class Restaurante extends Usuario {
	  Random rand = new Random();
	  private String cnpj;
	  private List<Produto> produtos = new ArrayList<>();
	  private int idRestaurante;
	  private int tempoEntrega = rand.nextInt(60);
	  private double taxaEntrega;
	  
	  public Restaurante(String cnpj, GerenciadorRestaurante gerenciador) {
	    this.cnpj = cnpj;
	    this.setIdRestaurante(gerenciador);
	  }
	  
	  public Produto criaProduto(String nome, String descricao, double preco) {
		  Produto produto = new Produto(nome,descricao,preco, this);
		  return produto;
	  }
	  
	  public int getTempoEntrega() {
		  return tempoEntrega;
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
	
	
	
	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	@Override
	public String toString() {
		return super.toString()+" cnpj: " + cnpj + ", produtos: " + produtos + ", idRestaurante: "
				+ idRestaurante + ", Tempo de Entrega: " + tempoEntrega + ", Taxa de Entrega: " + taxaEntrega + "]";
	}

	
	
	  
  
}