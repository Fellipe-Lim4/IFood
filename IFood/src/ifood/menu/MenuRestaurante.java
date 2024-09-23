package ifood.menu;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.usuarios.Restaurante;
import ifood.produtos.Item;
import java.util.Scanner;

public class MenuRestaurante {
	Scanner sc = new Scanner(System.in);

	
	public void exibirMenuRestaurante(GerenciadorRestaurante gerenciador) {
		Restaurante restauranteLogado = gerenciador.getRestauranteLogado();
		System.out.println(restauranteLogado.getNome());
		System.out.println("Escolha uma das opções:");
		System.out.println("1.Adicionar Produto");
		System.out.println("2.Remover Produto");
		System.out.println("3.Exibir Cardápio");
		int opc = sc.nextInt();
		switch(opc) { 
			case 1:
				System.out.println("\nAdicionar Produto");
				sc.nextLine();
				System.out.print("Nome do produto: ");
				String nome = sc.nextLine();
				System.out.print("Descrição do Produto: ");
				String descricao = sc.nextLine();
				System.out.print("Preço do Produto: ");
				double preco = sc.nextDouble();
				System.out.println(nome +  descricao + preco);
				Item produto = new Item(nome, descricao, preco);
				System.out.println("Produto Criado:" + produto.toString());
				//restauranteLogado.adicionaProduto(produto);
				System.out.println("Produto adicionado ao Cardápio.");
				sc.close();
		}
	}
}
