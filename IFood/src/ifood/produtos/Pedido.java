package ifood.produtos;
import java.time.LocalDate;
import ifood.produtos.ItensPedido;
import java.util.List;

import ifood.usuarios.Cliente;

public class Pedido {

  private List<ItensPedido> itens;
  private LocalDate data = LocalDate.now();
  private double valor;
  private int idCliente;

  public Pedido(List<ItensPedido> itens, double valor, int idCliente) {
	  this.setItens(itens);
	  this.setValor(valor);
	  this.setIdCliente(idCliente);
  }

  public int getIdCliente() {
	  return idCliente;
  }

  public void setIdCliente(int idCliente) {
	  this.idCliente = idCliente;
  }

  public List<ItensPedido> getItens() {
	  return itens;
  }

  public void setItens(List<ItensPedido> itens) {
	  this.itens = itens;
  }

  public double getValor() {
	  return valor;
  }

  public void setValor(double valor) {
	  this.valor = valor;
  }

  public LocalDate getData() {
	  return data;
  }

  public void setData(LocalDate data) {
	  this.data = data;
  }

	public double verificaPreco() {
		for(ItensPedido item:this.itens) {
			this.valor += item.getPreco(); 		// Soma os preços dos itens individuais
		}
	  	return this.valor;
	}

  @Override
  public String toString() {				// Para imprimir os dados do pedido
	  return "itens: " + itens + ", valor: " + valor + ", idCliente: " + idCliente + ", data : " + data;
  }
    
}
