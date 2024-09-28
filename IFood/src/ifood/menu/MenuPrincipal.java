package ifood.menu;
import ifood.gerenciadores.*;
import ifood.usuarios.Cliente;
import ifood.usuarios.Restaurante;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal implements Entrada {
	
	GerenciadorRestaurante gerenciadorRest;
	GerenciadorCliente gerenciadorCli;
	
	public MenuPrincipal(GerenciadorRestaurante gerenciadorRest, GerenciadorCliente gerenciadorCli) {
		this.gerenciadorRest = gerenciadorRest;
		this.gerenciadorCli = gerenciadorCli;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void exibirMenuPrincipal() {
		System.out.println("************************************");
        System.out.println("*             IFood                *");
        System.out.println("*                                  *");
        System.out.println("*     Autores: José Fellipe        *");
        System.out.println("*              Érico Alcântara     *");
        System.out.println("*                                  *");
        System.out.println("************************************");
		int opcao = 0;
		while(opcao!=3) {
			System.out.println("Digite a opção que você deseja:");
			System.out.println("1. Cadastrar-se no IFood.");
			System.out.println("2. Fazer Login.");
			System.out.println("3. Sair.");
			opcao = this.ScInt();
			switch(opcao) {
			case 1:
				cadastro();
				break;
			case 2:
				login();
				break;
			case 3:
				System.out.println("Obrigado por utilizar nosso aplicativo!");
				break;
			}
		}
	}


	private void cadastro() {
		int opc = 0;
		while(opc!=3) { 
			System.out.println("Escolha o tipo de Cadastro:");
			System.out.println("1. Cliente");
			System.out.println("2. Restaurante");
			System.out.println("3. Voltar");
			opc = this.ScInt();
			switch(opc) {
			case 1:
				System.out.print("\nDigite seu nome completo: ");
				String nome = sc.nextLine();
				System.out.print("Digite seu E-mail: ");
				String email = sc.nextLine();
				System.out.print("Crie uma senha: ");
				String senha = sc.nextLine();
				System.out.print("Digite seu telefone: ");
				String telefone = sc.nextLine();
				System.out.print("Digite seu endereço: ");
				String endereco = sc.nextLine();
				System.out.print("Digite seu sexo: ");
				String sexo = sc.nextLine();
				System.out.print("Digite sua data de nascimento: ");
				String dataNasc = sc.nextLine();
				this.gerenciadorCli.criarCliente(nome,email,senha,telefone,endereco,sexo,dataNasc, this.gerenciadorCli);
				System.out.println("Cliente cadastrado!");
				break;
			case 2:
				System.out.print("\nDigite o seu CNPJ: ");
				String cnpj = sc.nextLine();
				System.out.print("Digite o nome do restaurante: ");
				String nomeRest = sc.nextLine();
				System.out.print("Digite o seu E-mail: ");
				String emailRest = sc.nextLine();
				System.out.print("Crie uma senha: ");
				String senhaRest = sc.nextLine();
				System.out.print("Qual será a taxa de entrega do seu Restaurante? (Máximo:R$10,00) Valor: ");
				double taxaEntrega = ScDouble();
				while(taxaEntrega<=0 || taxaEntrega>10) {
					System.out.print("Digite uma taxa de entrega válida(Máx. R$10,00): ");
					taxaEntrega = ScDouble();
				}
				this.gerenciadorRest.criarRestaurante(cnpj, nomeRest, emailRest, senhaRest, taxaEntrega, this.gerenciadorRest);
				break;
			case 3:
				return;
			}
		}
	}
	
	private void login() {
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		List<Cliente> listaClientes = this.gerenciadorCli.getClientes();
		for(Cliente cliente : listaClientes) {
			if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
				System.out.println("Bem vindo, " + cliente.getNome() + "!");
				criarMenuCliente(cliente);
				return;
			}	
		}
		List<Restaurante> listaRestaurantes = this.gerenciadorRest.getRestaurantes();
		for(Restaurante restaurante : listaRestaurantes) {
			if(restaurante.getEmail().equals(email) && restaurante.getSenha().equals(senha)) {
				System.out.println("Bem vindo, " + restaurante.getNome() + "!");
				criarMenuRestaurante(restaurante);
				return;
			}	
		}
	}
	
	private void criarMenuRestaurante(Restaurante restauranteLog) {
		MenuRestaurante menuRes = new MenuRestaurante(gerenciadorRest,gerenciadorCli,restauranteLog);
		menuRes.exibirMenuRestaurante();
	}
	
	private void criarMenuCliente(Cliente clienteLog) {
		MenuCliente menuCliente = new MenuCliente(gerenciadorRest,gerenciadorCli,clienteLog);
		menuCliente.exibirMenuCliente();
	}

	@Override
	public int ScInt() {
		System.out.print("entrada: ");
		try {
			int entrada = Integer.parseInt(sc.nextLine());
			return entrada;
			
		} catch(NumberFormatException n) {
			System.out.println("Valor inválido.");
			return 0;
		}
	}

	@Override
	public double ScDouble() {
		double entrada = 0;
		boolean valido = false;
		while(!valido) {
			try {
				entrada = sc.nextDouble();
				while(entrada<=0) {
					System.out.print("\nValor inválido. Tente novamente: ");
					entrada = sc.nextDouble();
				}
				valido = true;
				return entrada;
			} catch(InputMismatchException i) {
				System.out.print("\nValor inválido. Tente novamente: ");
				sc.nextLine();
			}
		}
		return entrada;
	}
}
