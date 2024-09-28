package ifood.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import ifood.gerenciadores.GerenciadorCliente;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.produtos.Produto;
import ifood.usuarios.Cliente;
import ifood.usuarios.Restaurante;
import ifood.produtos.ItensPedido;
import ifood.produtos.Pedido;

public class MenuCliente extends MenuPrincipal {
	
	Scanner sc = new Scanner(System.in);
	GerenciadorCliente gerenciadorCli;
	GerenciadorRestaurante gerenciadorRest;
	Cliente clienteLogado;

	public MenuCliente(GerenciadorRestaurante gerenciadorRest, GerenciadorCliente gerenciadorCli, Cliente clienteLogado) {
		super(gerenciadorRest,gerenciadorCli);
		this.gerenciadorCli = gerenciadorCli;
		this.gerenciadorRest = gerenciadorRest;
		this.clienteLogado = clienteLogado;
	}
	
	
	public void exibirMenuCliente() {
		System.out.println(clienteLogado.getNome().toUpperCase());
		int opc = 0;
		while(opc!=5) {
			System.out.println("\nEscolha uma das opções:");
			System.out.print("\nRestaurantes Recomendados :");
			gerenciadorRest.exibirRestaurantes();
			System.out.println("\n1. Realizar pedido.");
			System.out.println("2. Exibir Histórico de pedidos.");
			System.out.println("3. Pesquisar");
			System.out.println("4. ");
			System.out.println("5. Sair");
			opc = super.ScInt();
			switch(opc) {
			case 1:
				fazerPedido();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Log off.");
				return;
			}
		}
	}


	private void fazerPedido() {
		if(gerenciadorRest.getRestaurantes().size()==0) {
			System.out.println("Não encontramos restaurantes!");
			return;
		}
		boolean pedidoTerminado = false;
		System.out.println("Realizar Pedido");
		List<ItensPedido> itens = new ArrayList<>();
		double valor = 0;
		int numRest = 0;
		System.out.print("\nLista de Restaurantes: ");
		gerenciadorRest.exibirRestaurantes();
		numRest = super.ScInt();
		while(!pedidoTerminado) {
			boolean valido = false;
			while(!valido) {
				try {
					Restaurante restaurante = gerenciadorRest.getRestaurantes().get(numRest-1);
					System.out.println("Restaurante: " + restaurante.getNome());
					restaurante.exibeProdutos();
					System.out.print("Digite o número do Prato que deseja pedir: ");
					int numPrato = super.ScInt();
					ItensPedido item = restaurante.getProdutos().get(numPrato-1);
					System.out.print("Digite a quantidade do item: " + item.getNome() + " que deseja pedir: ");
					int qtd = super.ScInt();
					valor+=qtd*item.getPreco();
					item.setQtd(qtd);
					itens.add(item);
					System.out.println("Item adicionado ao pedido: " + item.getNome() + ", Quantidade: " + item.getQtd());
					int opc = 0;
					while(opc!=1 && opc!=2) {
						System.out.println("Deseja continuar o pedido?");
						System.out.println("1. Sim");
						System.out.println("2. Não");
						opc = super.ScInt();
						switch(opc) {
						case 1:
							pedidoTerminado = false;
							break;
						case 2:
							pedidoTerminado = true;
							Pedido pedido = new Pedido(itens, valor, clienteLogado.getId());
							clienteLogado.getHistoricoPedidos().add(pedido);
							System.out.println("Pedido criado com sucesso!");
							System.out.println(pedido.toString());
							simulandoEntrega(restaurante.getTempoEntrega());
							break;
						}
					}
					valido = true;
				} catch(IndexOutOfBoundsException i) {
					System.out.println("Índice de produto inválido, Tente novamente.");
					}
			}
			}
		
		}


	private void simulandoEntrega(int tempoEntrega) {
		try {
			int tempoPreparo = tempoEntrega/5;
			System.out.println("Seu pedido está sendo preparado...");
			TimeUnit.SECONDS.sleep(tempoPreparo);
			int tempoEntregar = tempoEntrega/2;
			System.out.println("Seu pedido saiu para entrega...");
			TimeUnit.SECONDS.sleep(tempoEntregar);
			System.out.println("O entregador chegou no seu endereço: " + clienteLogado.getEndereco());
		} catch(InterruptedException i) {
			
		}
	}
		
	}


