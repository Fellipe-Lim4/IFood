package ifood.menu;
import ifood.gerenciadores.*;
import java.util.Scanner;

public class MenuPrincipal {
	
	GerenciadorRestaurante gerenciadorRest;
	
	public MenuPrincipal(GerenciadorRestaurante gerenciadorRest) {
		this.gerenciadorRest = gerenciadorRest;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void exibirMenuPrincipal() {
		System.out.println("Digite a opção que você deseja:");
		System.out.println("1. Cadastrar-se como Restaurante");
		int opcao = sc.nextInt();
		switch(opcao) {
		case 1:
			CadastroRestaurante cadastro = new CadastroRestaurante(this.gerenciadorRest);
			cadastro.exibirCadastroRestaurante();
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
}
