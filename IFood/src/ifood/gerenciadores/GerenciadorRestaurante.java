package ifood.gerenciadores;
import ifood.usuarios.Restaurante;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante {
	
  private Restaurante restauranteLogado;
  private List<Restaurante> restaurantes;
  DecimalFormat df = new DecimalFormat("#.00");
  
  public GerenciadorRestaurante() {
	  this.restaurantes = new ArrayList<>();
  }

  public void criarRestaurante(String cnpj, String nome, String email, String senha, double taxaEntrega, GerenciadorRestaurante gerenciadorRestaurante) {
    Restaurante restaurante = new Restaurante(cnpj, this);
    restaurante.setNome(nome);
    restaurante.setEmail(email);
    restaurante.setSenha(senha);
    restaurante.setTaxaEntrega(taxaEntrega);
    this.restaurantes.add(restaurante);
  }
  
  public boolean loginRestaurante(String email, String senha) {
	  for (Restaurante restaurante : this.restaurantes) {
		  if((restaurante.getEmail().equals(email))&&(restaurante.getSenha().equals(senha))) {
			  System.out.println("\nLogin realizado!\n");
			  this.setRestauranteLogado(restaurante);
			  return true;
		  }
	  }
	  System.out.println("Email ou senha incorretos.");
	  return false;
  }
  
  
  public Restaurante getRestauranteLogado() {
	return restauranteLogado;
  }

  public void setRestauranteLogado(Restaurante restauranteLogado) {
	this.restauranteLogado = restauranteLogado;
	}

  public void removerRestaurante(Restaurante restaurante) {
    this.restaurantes.remove(restaurante);
  }

  public List<Restaurante> getRestaurantes() {
    return this.restaurantes;
  } 

  public void exibirRestaurantes() {
    for (Restaurante restaurante : this.restaurantes) {
      System.out.println(restaurante.infoCliente());
    }
  }
  
  public Restaurante pesquisarRestauranteNome(String nome) {
	  return this.restaurantes.stream().filter(
			  restaurante -> restaurante.getNome().equals(nome)			  
			  ).findFirst().orElse(null);	  
  }
  
  public void exibirNomeAvaliacoes(List<Restaurante> restaurantes) {
		System.out.print("\n{");
		int contador = 0;
		for(Restaurante restaurante: restaurantes) {
			contador++;
			System.out.print("["+contador+ ". Nome: " + restaurante.getNome() + ", Média de Avaliação: " + restaurante.getMediaAvaliacoes() + "]");
		}
		System.out.print("}");
	}
  
  public void exibirNomeTaxaEntrega(List<Restaurante> restaurantes) {
		System.out.print("\n{");
		int contador = 0;
		for(Restaurante restaurante: restaurantes) {
			contador++;
			System.out.print("["+contador+ ". Nome: " + restaurante.getNome() + ", Taxa de Entrega: R$" + df.format(restaurante.getTaxaEntrega()) + "]");
		}
		System.out.print("}");
	}
  
  public void exibirNomeTempoEntrega(List<Restaurante> restaurantes) {
		System.out.print("\n{");
		int contador = 0;
		for(Restaurante restaurante: restaurantes) {
			contador++;
			System.out.print("["+contador+ ". Nome: " + restaurante.getNome() + ", Tempo de Entrega: " + restaurante.getTempoEntrega() + " minutos]");
		}
		System.out.print("}");
	}
  
  public void exibirNomePrecoMedio(List<Restaurante> restaurantes) {
		System.out.print("\n{");
		int contador = 0;
		for(Restaurante restaurante: restaurantes) {
			contador++;
			System.out.print("["+contador+ ". Nome: " + restaurante.getNome() + ", Preço Médio: R$" +  df.format(restaurante.getMediaPreco()) + "]");
		}
		System.out.print("}");
	}
}