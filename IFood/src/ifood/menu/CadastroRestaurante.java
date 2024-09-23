package ifood.menu;
import java.util.Scanner;
import ifood.gerenciadores.GerenciadorRestaurante;

public class CadastroRestaurante extends LoginRestaurante {
	
	Scanner sc = new Scanner(System.in);
	
	public void exibirCadastroRestaurante(GerenciadorRestaurante gerenciador) {
		System.out.println("CADASTRO RESTAURANTE");
		System.out.print("CNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		gerenciador.criarRestaurante(cnpj, nome, email, senha);
		System.out.println("\nRealize o Login\n");
		this.loginRestaurante(gerenciador);
	}
}
