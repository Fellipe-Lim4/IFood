package ifood.main;

import ifood.gerenciadores.*;


public class Main {
  public static void main(String[] args) {
    // Instancia os gerenciadores
    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    GerenciadorRestaurante gerenciadorRestaurante = new GerenciadorRestaurante();
    
    // Comentei os trechos abaixo porque estas operações já estão sendo realizadas pelos gerenciadores
    
//    Restaurante restaurante = new Restaurante("Restaurante A", "Rua A, 123", "123456789", "joao@email", "123456789");
//    System.out.println(restaurante.toString());

    //System.out.println("Cadastrar: \n\t1 Cliente\n\t2 Restaurante");    // Apenas uma ideia de prompt pra o usuário na hora do cadastro. Aberto a sugestões. Devo mover para uma classe externa ou algo assim.
    /*int opcao = Integer.parseInt(System.console().readLine());

    switch (opcao){
        case 1:
            System.out.println("Cadastrar Cliente");
            gerenciadorCliente.criarCliente("123456789", "João", "joao@email", "123456");
            break;
        case 2:
            System.out.println("Cadastrar Restaurante");
            gerenciadorRestaurante.criarRestaurante("123456789", "João", "joao@email", "123456");
            break;
        default:
            break;
    }
  }
    
  
}
*/
      gerenciadorRestaurante.criarRestaurante("12.345.678/0001-951", "João Silva", "joao.silva123@example.com","P@ssw0rd!20244");
      gerenciadorRestaurante.exibirRestaurantes();
    }     
}
