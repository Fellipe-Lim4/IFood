package ifood.menu;
import java.util.Scanner;
import ifood.gerenciadores.GerenciadorRestaurante;

public class LoginRestaurante extends MenuRestaurante {
	
	Scanner sc = new Scanner(System.in);
	
	public void loginRestaurante(GerenciadorRestaurante gerenciador) {
		System.out.println("---LOGIN---    Voltar-0");
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		boolean loginCompleto = gerenciador.loginRestaurante(email, senha);
		if(loginCompleto) {
			System.out.println("Exibindo Menu de Restaurante...");
			this.exibirMenuRestaurante(gerenciador);
		} else {
			this.loginRestaurante(gerenciador);
		}
	}
}
