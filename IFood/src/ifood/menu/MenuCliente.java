package ifood.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ifood.gerenciadores.Avaliacao;
import ifood.gerenciadores.GerenciadorCliente;
import ifood.gerenciadores.GerenciadorRestaurante;
import ifood.ordenacao.OrdenacaoAvaliacao;
import ifood.ordenacao.OrdenacaoTaxaEntrega;
import ifood.ordenacao.OrdenacaoTempoEntrega;
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
			System.out.print("\nRestaurantes Recomendados: ");
			gerenciadorRest.exibirRestaurantes();
			System.out.println("\n1. Realizar pedido.");
			System.out.println("2. Exibir Histórico de pedidos.");
			System.out.println("3. Pesquisar Restaurantes.");
			System.out.println("4. Ordenar Restaurantes.");
			System.out.println("5. Sair");
			opc = super.ScInt();
			switch(opc) {
			case 1:
				fazerPedidoPeloMenu();
				break;
			case 2:
				System.out.println("\n========================================");
				clienteLogado.exibirHistoricoPedidos();
				System.out.println("========================================");
				break;
			case 3:
				System.out.print("Buscar: ");
				String nome = sc.nextLine();
				try {
					Restaurante restaurante = gerenciadorRest.pesquisarRestauranteNome(nome);
					System.out.println("Restaurante encontrado: " +  restaurante.infoCliente());
					fazerPedidoPesquisa(restaurante);
				} catch(NullPointerException n) {
					System.out.println("Restaurante " + nome + " não encontrado.");
				}
				break;
			case 4:
				menuOrdenacao();
				break;
			case 5:
				System.out.println("Log off.");
				return;
			}
		}
	}
	
	private void menuOrdenacao() {
		int opc = 0;
		while(opc!=4) {
			System.out.println("\nVocê deseja fazer qual filtragem?");
			System.out.println("1. Ordenação por maior avaliação.");
			System.out.println("2. Ordenação por menor taxa de entrega.");
			System.out.println("3. Ordenação por menor tempo de entrega.");
			System.out.println("4. Ordenação por média de preço.");
			System.out.println("5. Sair.");
			opc = ScInt();
			switch(opc) {
			case 1:
				OrdenacaoAvaliacao ordenacaoAva = new OrdenacaoAvaliacao();
				List<Restaurante> listaRest = gerenciadorRest.getRestaurantes();
				Collections.sort(listaRest, ordenacaoAva);
				gerenciadorRest.exibirNomeAvaliacoes(listaRest);
				break;
			case 2:
				OrdenacaoTaxaEntrega ordenacaoEntrega = new OrdenacaoTaxaEntrega();
				List<Restaurante> listaRestEnt = gerenciadorRest.getRestaurantes();
				Collections.sort(listaRestEnt, ordenacaoEntrega);
				gerenciadorRest.exibirNomeTaxaEntrega(listaRestEnt);
				break;
			case 3:
				OrdenacaoTempoEntrega ordenacaoTempoEntrega = new OrdenacaoTempoEntrega();
				List<Restaurante> listaRestTemp = gerenciadorRest.getRestaurantes();
				Collections.sort(listaRestTemp, ordenacaoTempoEntrega);
				gerenciadorRest.exibirNomeTempoEntrega(listaRestTemp);
				break;
			case 4:
				OrdenacaoTempoEntrega ordenacaoPrecoMedio = new OrdenacaoTempoEntrega();
				List<Restaurante> listaRestPreco = gerenciadorRest.getRestaurantes();
				Collections.sort(listaRestPreco, ordenacaoPrecoMedio);
				gerenciadorRest.exibirNomePrecoMedio(listaRestPreco);
				break;
			case 5:
				return;
			}
		}
		
	}


	private void fazerPedidoPesquisa(Restaurante restaurante) {
		int opc = 0;
		while(opc!=1 && opc!=2) {
			System.out.println("Você deseja fazer o pedido no restaurante pesquisado?");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			opc = ScInt();
			switch(opc) {
			case 1:
				break;
			case 2:
				return;
			}
		}
		double valor = 0;
		List<ItensPedido> itens = new ArrayList<>();
		boolean pedidoTerminado = false;
		while(!pedidoTerminado) {
			boolean valido = false;
			while(!valido) {
				try {
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
					System.out.println("Item adicionado ao pedido: " + item.getNome() + ", Quantidade: " + item.getQtd() +", Valor: "+ valor);
					int opcao = 0;
					while(opcao!=1 && opcao!=2) {
						System.out.println("Deseja continuar o pedido?");
						System.out.println("1. Sim");
						System.out.println("2. Não");
						System.out.println("3. Cancelar Pedido");
						opcao = super.ScInt();
						switch(opcao) {
						case 1:
							pedidoTerminado = false;
							break;
						case 2:
							pedidoTerminado = true;
							valor+=restaurante.getTaxaEntrega();
							Pedido pedido = new Pedido(itens, valor, clienteLogado.getId());
							clienteLogado.getHistoricoPedidos().add(pedido);
							System.out.println("Pedido criado com sucesso!");
							System.out.println(pedido.toString());
							simulandoEntrega(restaurante.getTempoEntrega());
							avaliarRestaurante(restaurante);
							break;
						case 3:
							return;
						} 
					}
				} catch(IndexOutOfBoundsException i) {
					System.out.println("Índice de produto inválido.");
					}
			}
		}
	}
	

	private void fazerPedidoPeloMenu() {
		if(gerenciadorRest.getRestaurantes().isEmpty()) {
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
					valido = true;
					System.out.print("Digite a quantidade do item: " + item.getNome() + " que deseja pedir: ");
					int qtd = super.ScInt();
					valor+=qtd*item.getPreco();
					item.setQtd(qtd);
					itens.add(item);
					System.out.println("Item adicionado ao pedido: " + item.getNome() + ", Quantidade: " + item.getQtd() +", Valor: "+ valor);
					int opc = 0;
					while(opc!=1 && opc!=2) {
						System.out.println("Deseja continuar o pedido?");
						System.out.println("1. Sim");
						System.out.println("2. Não");
						System.out.println("3. Cancelar Pedido");
						opc = super.ScInt();
						switch(opc) {
						case 1:
							pedidoTerminado = false;
							break;
						case 2:
							pedidoTerminado = true;
							valor+=restaurante.getTaxaEntrega();
							Pedido pedido = new Pedido(itens, valor, clienteLogado.getId());
							clienteLogado.getHistoricoPedidos().add(pedido);
							System.out.println("Pedido criado com sucesso!");
							System.out.println(pedido.toString());
							simulandoEntrega(restaurante.getTempoEntrega());
							avaliarRestaurante(restaurante);
							break;
						case 3:
							return;
						} 
					}
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
	
	private void avaliarRestaurante(Restaurante restaurante) {
		int escolha = 0;
		while(escolha!=1 && escolha!=2) {
			System.out.println("Deseja fazer uma avaliação para o restaurante?");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			escolha = ScInt();
			switch(escolha) {
			case 1:
				break;
			case 2:
				return;
			}
		}
		System.out.println("Qual a sua nota para o serviço do restaurante: " + restaurante.getNome() + "?");
		System.out.print("Nota de 0 a 5: ");
		double nota = super.ScDouble();
		while(nota<0 || nota>5) {
			System.out.println("Nota inválida.");
			System.out.print("Nota de 0 a 5: ");
			nota = super.ScDouble();
		}
		int opc = 0;
		while(opc!=2) {
			System.out.println("Deseja fazer um comentário para o restaurante?");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			opc = ScInt();
			switch(opc) {
			case 1:
				System.out.print("Escreva seu comentário: ");
				String comentario = sc.nextLine();
				System.out.println("Obrigado pela avaliação!");
				Avaliacao avaliacao = new Avaliacao(nota, comentario);
				restaurante.adicionarAvaliacao(avaliacao);
				opc = 2;
				break;
			case 2:
				System.out.println("Obrigado pela avaliação!");
				Avaliacao avaliacaoSemComentario = new Avaliacao(nota, null);
				restaurante.adicionarAvaliacao(avaliacaoSemComentario);
				break;
			}
		}
		
	}
	
	}


