package ifood.menu;
import java.util.Scanner;

public class MenuPrincipal {
	Scanner sc = new Scanner(System.in);
	
	public void exibirMenuPrincipal() {
		System.out.println("Digite a opção que você deseja:");
		System.out.println("1. Cadastrar-se como Restaurante");
		int opcao = sc.nextInt();
		switch(opcao) {
		case 1:
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
}
