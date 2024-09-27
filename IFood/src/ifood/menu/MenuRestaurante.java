package ifood.menu;
import ifood.gerenciadores.GerenciadorCliente;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.usuarios.Restaurante;
import ifood.produtos.Produto;
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
		while(opc!=4) {
			System.out.println("\nEscolha uma das opções:");
			System.out.println("1.Adicionar Produto");
			System.out.println("2.Remover Produto");
			System.out.println("3.Exibir Cardápio");
			System.out.println("4. Sair");
			opc = super.ScInt();
			switch(opc) {
			case 1:
				adicionaProduto();
				break;
			case 2:
				removeProduto();
				break;
			case 3:
				exibeProdutos();
				break;
			case 4:
				return;
			}
		}
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
		Produto produtoAdd = restauranteLogado.criaProduto(nome, descricao, preco);
		restauranteLogado.adicionaProduto(produtoAdd);
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
}