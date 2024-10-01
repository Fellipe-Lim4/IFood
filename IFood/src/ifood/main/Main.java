package ifood.main;
import ifood.menu.*;
import ifood.usuarios.Restaurante;

import java.time.LocalDate;

import ifood.gerenciadores.*;


public class Main {
  public static void main(String[] args) {
    // Instancia os gerenciadores
      GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
      GerenciadorRestaurante gerenciadorRestaurante = new GerenciadorRestaurante();
    
	  gerenciadorCliente.criarCliente("João", "joao", "12345", "999999999", "Rua A, 123", "M", "01/01/1992", gerenciadorCliente);

	  
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante1", "joao.s@example.com","P@ssw0rd!20244", 5 , gerenciadorRestaurante);
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante2", "joao.@example.com","P@ssw0rd!20244", 3 , gerenciadorRestaurante);
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante3", "joao.silva@example.com","P@ssw0rd!20244", 6 , gerenciadorRestaurante);
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante4", "joao.silva1@example.com","P@ssw0rd!20244", 9 , gerenciadorRestaurante);
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante5", "joao.silva12@example.com","P@ssw0rd!20244", 1 , gerenciadorRestaurante);
	  gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "Restaurante6", "joao.silva123@example.com","P@ssw0rd!20244", 7 , gerenciadorRestaurante);
	 
      Restaurante restaurante1 = gerenciadorRestaurante.getRestaurantes().getFirst();
      Restaurante restaurante2 = gerenciadorRestaurante.getRestaurantes().get(1);
      Restaurante restaurante3 = gerenciadorRestaurante.getRestaurantes().get(2);
      Restaurante restaurante4 = gerenciadorRestaurante.getRestaurantes().get(3);
      Restaurante restaurante5 = gerenciadorRestaurante.getRestaurantes().get(4);
      Restaurante restaurante6 = gerenciadorRestaurante.getRestaurantes().get(5);
      restaurante1.criaProduto("coca", "gelada", 12);
      restaurante2.criaProduto("bolacha", "mole", 20);
      restaurante3.criaProduto("Strogonoff", "apimentado", 49.50);
      restaurante4.criaProduto("Lasanha", "Bolonhesa", 52);
      restaurante5.criaProduto("Parmegiana", "Carne", 62);
      restaurante6.criaProduto("Risoto", "Arroz", 67);
	  Avaliacao avaliacao1 = new Avaliacao(5.0,"Sensacional!");
	  Avaliacao avaliacao2 = new Avaliacao(3.0,"daora!");
	  Avaliacao avaliacao3 = new Avaliacao(4.0,"legal!");
	  Avaliacao avaliacao4 = new Avaliacao(2.0,"bom!");
	  Avaliacao avaliacao5 = new Avaliacao(1.0,"Sensacional!");
	  Avaliacao avaliacao6 = new Avaliacao(2.0,"Sensacional!");
	  restaurante1.adicionarAvaliacao(avaliacao1);
	  restaurante2.adicionarAvaliacao(avaliacao2);
	  restaurante3.adicionarAvaliacao(avaliacao3);
	  restaurante4.adicionarAvaliacao(avaliacao4);
	  restaurante5.adicionarAvaliacao(avaliacao5);
	  restaurante6.adicionarAvaliacao(avaliacao6);
	  restaurante1.criarCupom("cupom70", 70.0, 0, LocalDate.parse("2024-11-28"), false);
	  restaurante1.criarCupom("cupomvencido", 1.0, 0.0, LocalDate.parse("2004-11-28"), false);
	  MenuPrincipal menu = new MenuPrincipal(gerenciadorRestaurante,gerenciadorCliente);
	  menu.exibirMenuPrincipal(); 
    }     
}
