package ifood.menu;
import java.util.Scanner;
import ifood.gerenciadores.GerenciadorRestaurante;

public class CadastroRestaurante extends MenuPrincipal{
	GerenciadorRestaurante gerenciador;
	
	public CadastroRestaurante(GerenciadorRestaurante gerenciador) {
		super(gerenciador);
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	
	public void exibirCadastroRestaurante() {
		System.out.println("CADASTRO RESTAURANTE");
		System.out.print("CNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		this.gerenciador.criarRestaurante(cnpj, nome, email, senha);
		System.out.println("\nRealize o Login\n");
		LoginRestaurante login = new LoginRestaurante(gerenciador);
		login.loginRestaurante();
	}
}
