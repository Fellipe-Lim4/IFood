package ifood.menu;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.usuarios.Restaurante;
import ifood.produtos.Produto;
import java.util.Scanner;

public class MenuRestaurante extends MenuPrincipal {
	Scanner sc = new Scanner(System.in);
	GerenciadorRestaurante gerenciador;
	Restaurante restauranteLogado;
	
	public MenuRestaurante(GerenciadorRestaurante gerenciador) {
		super(gerenciador);
		this.restauranteLogado = gerenciador.getRestauranteLogado();
	}
	
	public void exibirMenuRestaurante() {
		System.out.println(restauranteLogado.getNome().toUpperCase());
		System.out.println("Escolha uma das opções:");
		System.out.println("1.Adicionar Produto");
		System.out.println("2.Remover Produto");
		System.out.println("3.Exibir Cardápio");
		int opc = sc.nextInt();
		if(opc==1)this.menuAdicionaProduto();
		if(opc==2)this.menuRemoveProduto();
		if(opc==3)this.menuExibeProdutos();
	}
		
	public void menuAdicionaProduto() {
		System.out.println("\nAdicionar Produto");
		sc.nextLine();
		System.out.print("Nome do produto: ");
		String nome = sc.nextLine();
		System.out.print("Descrição do Produto: ");
		String descricao = sc.nextLine();
		System.out.print("Preço do Produto: ");
		double preco = sc.nextDouble();
		System.out.println(nome + " " +  descricao + " " + preco);
		Produto produto = new Produto(nome, descricao, preco);
		restauranteLogado.adicionaProduto(produto);
		System.out.println("Produto adicionado ao Cardápio.");
	}
	public void menuRemoveProduto() {
		System.out.println("\nRemover Produto");
		restauranteLogado.exibeProdutos();
		System.out.print("\nDigite o número do produto que você deseja remover:");
		int numProd = sc.nextInt();
		Produto produtoRemover = restauranteLogado.getProdutos().get(numProd-1);
		restauranteLogado.removeProduto(produtoRemover);
		restauranteLogado.exibeProdutos();
		sc.close();
		}
	public void menuExibeProdutos() {
		System.out.println("\nExibir Produtos");
		restauranteLogado.exibeProdutos();
	}
}