package ifood.gerenciadores;
import ifood.usuarios.Restaurante;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRestaurante {
  
  private List<Restaurante> restaurantes = new ArrayList<>();

  public void criarRestaurante(String cnpj, String nome, String email, String senha) {
    Restaurante restaurante = new Restaurante(cnpj);
    restaurante.setNome(nome);
    restaurante.setEmail(email);
    restaurante.setSenha(senha);
    this.restaurantes.add(restaurante);
  }
  
  public void LoginRestaurante(String email, String senha) {
	  for (Restaurante restaurante : this.restaurantes) {
		  if((restaurante.getEmail().equals(email))&&(restaurante.getSenha().equals(senha))) {
			  System.out.println("Login realizado!");
		  }
	  }
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