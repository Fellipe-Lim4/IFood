package ifood.usuarios;

import ifood.produtos.Produto;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

import ifood.gerenciadores.Avaliacao;
import ifood.gerenciadores.GerenciadorRestaurante;
import java.util.Random;

public class Restaurante extends Usuario {
	  Random rand = new Random();
	  DecimalFormat df = new DecimalFormat("#.00");
	  private String cnpj;
	  private List<Produto> produtos;
	  private int idRestaurante;
	  private int tempoEntrega = rand.nextInt(10,60);
	  private double taxaEntrega;
	  private List<Avaliacao> avaliacoes;
	  private double mediaAvaliacoes;
	  private double mediaPreco;
	  
	  public Restaurante(String cnpj, GerenciadorRestaurante gerenciador) {
	    this.cnpj = cnpj;
	    this.setIdRestaurante(gerenciador);
	    this.produtos = new ArrayList<>();
	    this.avaliacoes = new ArrayList<>();
	    this.mediaAvaliacoes = 0.0;
	  }
	  
	  public Produto criaProduto(String nome, String descricao, double preco) {
		  Produto produto = new Produto(nome,descricao,preco, this);
		  adicionaProduto(produto);
		  setMediaPreco();
		  return produto;
	  }
	  
	  private void setMediaPreco() {
		  double somaPreco = 0;
		  for(Produto produto : this.produtos) {
			  somaPreco+=produto.getPreco();
		  }
		  this.mediaPreco = somaPreco/this.produtos.size();
	  }
	  
	  public double getMediaPreco() {
		  return this.mediaPreco;
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
	  
	  public String toStringProdutos() {
		String lista = "";
		for(Produto produto : this.produtos) {
			lista+=produto.toString();
			}
		return lista;
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
	
	public void adicionarAvaliacao(Avaliacao avaliacao) {
		this.avaliacoes.add(avaliacao);
		atualizarMediaAvaliacoes();
	}
	
	private void atualizarMediaAvaliacoes() {
		double somaNotas = 0;
		for(Avaliacao avaliacao : this.avaliacoes) {
			somaNotas+=avaliacao.getNota();
		}
		this.mediaAvaliacoes = somaNotas/this.avaliacoes.size();
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	public String toStringAvaliacoes() {
		String lista = "";
		for(Avaliacao avaliacao : this.avaliacoes) {
			lista+=avaliacao.toString();
		}
		return lista;
	}
	
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public double getMediaAvaliacoes() {
		return mediaAvaliacoes;
	}

	public void setMediaAvaliacoes(double mediaAvaliacoes) {
		this.mediaAvaliacoes = mediaAvaliacoes;
	}
	

	@Override
	public String toString() {
		return super.toString()+" cnpj: " + cnpj + ", produtos: " + produtos + ", idRestaurante: "
				+ idRestaurante + ", Tempo de Entrega: " + tempoEntrega + ", Taxa de Entrega: $" + df.format(taxaEntrega) + "]";
	}

	public String infoCliente() {
		return "Nome: " + getNome() + ", Produtos: " + toStringProdutos() + ", Avaliações: " + toStringAvaliacoes() + ", Taxa de Entrega: R$" + df.format(getTaxaEntrega()); 
	}
	
		
  
}