package ifood.gerenciadores;
import ifood.usuarios.Restaurante;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante {
	
	private Restaurante restauranteLogado;
	private List<Restaurante> restaurantes;
  
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
			System.out.println(restaurante.toString());
		}
	}
}