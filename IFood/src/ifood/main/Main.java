package ifood.main;

import ifood.gerenciadores.*;


public class Main {
  public static void main(String[] args) {
    // Instancia os gerenciadores
      GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
      GerenciadorRestaurante gerenciadorRestaurante = new GerenciadorRestaurante();
    
	  gerenciadorCliente.criarCliente("João", "joao@exemplo.com", "12345", "999999999", "Rua A, 123", "123.456.789-10", "M", "01/01/1992");
	  gerenciadorCliente.exibirClientes(); 
	  
      gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante1", "joao.silva123@example.com","P@ssw0rd!20244");
      gerenciadorRestaurante.exibirRestaurantes();
    }     
}
