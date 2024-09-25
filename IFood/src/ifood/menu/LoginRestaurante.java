package ifood.menu;
import java.util.Scanner;
import ifood.gerenciadores.GerenciadorRestaurante;

public class LoginRestaurante extends MenuPrincipal  {
	GerenciadorRestaurante gerenciador;
	
	public LoginRestaurante(GerenciadorRestaurante gerenciador) {
		super(gerenciador);
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	
	public void loginRestaurante() {
		System.out.println("---LOGIN---    Voltar-0");
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		boolean loginCompleto = gerenciador.loginRestaurante(email, senha);
		if(loginCompleto) {
			System.out.println("Exibindo Menu de Restaurante...");
			MenuRestaurante menuRest = new MenuRestaurante(gerenciador);
			menuRest.exibirMenuRestaurante();
		} else {
			this.loginRestaurante();
		}
	}
}
