package ifood.menu;
import java.util.Scanner;
import ifood.gerenciadores.GerenciadorRestaurante;

public class CadastroRestaurante {
	
	Scanner sc = new Scanner(System.in);
	
	public void exibirCadastroRestaurante(GerenciadorRestaurante gerenciador) {
		System.out.println("CADASTRO RESTAURANTE");
		System.out.print("/nCNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("/nNome: ");
		String nome = sc.nextLine();
		System.out.print("/nEmail: ");
		String email = sc.nextLine();
		System.out.print("/nSenha: ");
		String senha = sc.nextLine();
		gerenciador.criarRestaurante(cnpj, nome, email, senha);
	}
}
