package ifood.menu;
import ifood.gerenciadores.GerenciadorCliente;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.usuarios.Restaurante;
import ifood.produtos.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuRestaurante extends MenuPrincipal {

	Scanner sc = new Scanner(System.in);
	GerenciadorRestaurante gerenciador;
	Restaurante restauranteLogado;
	
	public MenuRestaurante(GerenciadorRestaurante gerenciadorRest, GerenciadorCliente gerenciadorCli, Restaurante restauranteLogado) {
		super(gerenciadorRest, gerenciadorCli);
		this.restauranteLogado = restauranteLogado;
	}

	public void exibirMenuRestaurante() {
		System.out.println(restauranteLogado.getNome().toUpperCase());
		int opc = 0;
		while(opc!=5) {
			System.out.println("\nEscolha uma das opções:");
			System.out.println("1. Adicionar Produto");
			System.out.println("2. Remover Produto");
			System.out.println("3. Altera Produto");
			System.out.println("4. Exibe Cardápio");
			System.out.println("5. Exibir informações do Restaurante.");
			System.out.println("6. Cadastrar Cupom.");
			System.out.println("7. Exibir Cupons.");
			System.out.println("8. Sair");

			opc = super.ScInt();
			switch(opc) {
			case 1:
				adicionaProduto();
				break;
			case 2:
				removeProduto();
				break;
			case 3:
				alteraProduto();
				break;
			case 4:
				exibeProdutos();
				break;
			case 5:
				System.out.println(restauranteLogado.toString());
				break;	
			case 6:
				cadastrarCupom();
				break;
			case 7:
				System.out.println(restauranteLogado.getCupons());
				break;
			case 8:
				return;
			}
		}
	}
	
	private void cadastrarCupom() {
		System.out.println("Cadastro de Cupom");
		System.out.print("\nCrie um código de ativação para o cliente usar o cupom: ");
		String codAtivacao = sc.nextLine();
		int opc = 0;
		double percentual = 100;
		double fixo = 0;
		while(opc!=1 && opc!=2) {
			System.out.println("O desconto será fixo ou percentual?");
			System.out.println("1. Fixo.");
			System.out.println("2. Percentual.");
			System.out.println("3. Sair.");
			opc = ScInt();
			switch(opc) {
			case 1:
				while(fixo==0) {
					System.out.print("Digite o desconto fixo do cupom: ");
					fixo = ScDouble();
				}
				break;
			case 2:
				while(percentual>=100 || percentual<=0) {
					System.out.print("Digite o desconto percentual do cupom: ");
					percentual = ScDouble();
				}
				if(percentual>=10) {
					percentual = percentual/100;
				} 
				if(percentual>=1) {
					percentual = percentual/100;
				}
				break;
			case 3:
				return;
			}
		}
		if(percentual==100) percentual = 0;
		LocalDate data = LocalDate.now();
		boolean valido = false;
		while(!valido) {
			DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.print("Digite sua data de expiração no modelo dia/mes/ano: ");
			String dataS = sc.nextLine();
			try {
				data = LocalDate.parse(dataS,dataFormat);
				if(data.isBefore(LocalDate.now())) {
					valido = false;
					System.out.println("Essa data já passou!");
				} else {
					System.out.println("Data válida.");
					valido = true;
				}
			} catch(DateTimeParseException d) {
				valido = false;
				}
			}
		boolean freteGratis;
		String escolha = "";
		while(!escolha.equals("s") && !escolha.equals("n")) {
			System.out.print("O cupom vai permitir entrega grátis? [S/N]");
			escolha = sc.nextLine().toLowerCase();
		}
		if(escolha.equals("s")) {
			freteGratis = true;
		} else {
			freteGratis = false;
		}
		restauranteLogado.criarCupom(codAtivacao, fixo, percentual , data, freteGratis);
		System.out.println("Cupom criado!");
		}

	public void adicionaProduto() {
		System.out.println("\nAdicionar Produto");
		System.out.print("Nome do produto: ");
		String nome = sc.nextLine();
		System.out.print("Descrição do Produto: ");
		String descricao = sc.nextLine();
		System.out.print("Preço do Produto: ");
		double preco = super.ScDouble();
		while(preco<=0) {
			System.out.print("Digite um preço válido: ");
			preco = super.ScDouble();
		}
		Produto produtoA = restauranteLogado.criaProduto(nome, descricao, preco);
		System.out.println("Produto adicionado ao Cardápio.");
	}
	
	public void removeProduto() {
		System.out.println("\nRemover Produto");
		restauranteLogado.exibeProdutos();
		System.out.print("\nDigite o número do produto que você deseja remover:");
		int numProd = super.ScInt();
		boolean valido = false;
		while(!valido) {
			try {
				Produto produtoRemover = restauranteLogado.getProdutos().get(numProd-1);
				restauranteLogado.removeProduto(produtoRemover);
				System.out.println("Produto: " + produtoRemover.getNome() + " removido com sucesso.");
				restauranteLogado.exibeProdutos();
				valido = true;
			} catch(IndexOutOfBoundsException i) {
				System.out.println("Índice de produto inválido, Tente novamente.");
				numProd = super.ScInt();
				}
		}
		
		}
	
	public void exibeProdutos() {
		System.out.println("\nExibir Produtos");
		restauranteLogado.exibeProdutos();
	}
	
	private void alteraProduto() {
		if(restauranteLogado.getProdutos().size()==0) {
			restauranteLogado.exibeProdutos();
			return;
		}
		System.out.println("\nAlterar produto");
		restauranteLogado.exibeProdutos();
		System.out.print("\nDigite o número do produto que você deseja alterar:");
		int numProd = super.ScInt();
		boolean valido = false;
		Produto produtoAlterar = new Produto(null,null,0, restauranteLogado);
		while(!valido) {
			try {

				produtoAlterar = new Produto(restauranteLogado.getProdutos().get(numProd-1).getNome(),restauranteLogado.getProdutos().get(numProd-1).getDescricao(),restauranteLogado.getProdutos().get(numProd-1).getPreco(), restauranteLogado);
				System.out.println("Produto: " + produtoAlterar.getNome() + " será alterado.");
				restauranteLogado.exibeProdutos();
				valido = true;
			} catch(IndexOutOfBoundsException i) {
				System.out.println("Índice de produto inválido, Tente novamente.");
				numProd = super.ScInt();
				}
		int opc = 0;
		while(opc!=4) {
			System.out.println(produtoAlterar.toString());
			System.out.println("1. Alterar nome do produto.");
			System.out.println("2. Alterar descrição do produto.");
			System.out.println("3. Alterar preço do produto.");
			System.out.println("4. Sair");
			opc = super.ScInt();
			switch(opc) {
			case 1:				
				System.out.println("Nome atual: " + produtoAlterar.getNome());
				System.out.print("\nDigite o novo nome: ");
				String novoNome = sc.nextLine();
				produtoAlterar.setNome(novoNome);
				System.out.println("Novo nome: " + produtoAlterar.getNome());
				break;
			case 2:
				System.out.println("Descrição atual: " + produtoAlterar.getDescricao());
				System.out.print("\nDigite a nova descrição: ");
				String novaDescricao = sc.nextLine();
				produtoAlterar.setDescricao(novaDescricao);
				System.out.println("Nova descrição: " + produtoAlterar.getDescricao());
				break;
			case 3:
				System.out.println("Preço atual: " + produtoAlterar.getPreco());
				System.out.print("\nDigite o novo preço: ");
				double novoPreco = super.ScDouble();
				while(novoPreco<=0) {
					System.out.print("Digite um preço válido: ");
					novoPreco = super.ScDouble();
				}
				produtoAlterar.setPreco(novoPreco);
				System.out.println("Novo preço: " + produtoAlterar.getPreco());
				break;
			case 4:
				restauranteLogado.getProdutos().remove(numProd-1);
				restauranteLogado.getProdutos().add(numProd-1, produtoAlterar);
				return;	
			}
		}
		
		}
	}
}