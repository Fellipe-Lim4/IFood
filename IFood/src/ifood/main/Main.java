package ifood.main;
import ifood.menu.*;
import ifood.usuarios.Restaurante;
import ifood.gerenciadores.*;


public class Main {
  public static void main(String[] args) {
    // Instancia os gerenciadores
      GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
      GerenciadorRestaurante gerenciadorRestaurante = new GerenciadorRestaurante();
    
	  gerenciadorCliente.criarCliente("João", "joao", "12345", "999999999", "Rua A, 123", "M", "01/01/1992", gerenciadorCliente);
	  gerenciadorCliente.exibirClientes(); 
	  
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante1", "joao.silva123@example.com","P@ssw0rd!20244", 5 , gerenciadorRestaurante);
      gerenciadorRestaurante.exibirRestaurantes();
      Restaurante restaurante = gerenciadorRestaurante.getRestaurantes().getFirst();
	  restaurante.adicionaProduto(restaurante.criaProduto("coca", "gelada", 12));
	  MenuPrincipal menu = new MenuPrincipal(gerenciadorRestaurante,gerenciadorCliente);
	  menu.exibirMenuPrincipal();
    }     
}
