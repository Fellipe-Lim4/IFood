package ifood.produtos;
import java.time.LocalDate;
import java.util.List;

import ifood.gerenciadores.GerenciadorCliente;
import ifood.usuarios.Cliente;

public class Pedido {
  private List<ItensPedido> itens;
  private LocalDate data = LocalDate.now();
  private double valor;
  private int idCliente;
  private int idPedido;

  public Pedido(List<ItensPedido> itens, double valor, int idCliente) {
    this.setItens(itens);
    this.setValor(valor);
    this.setIdCliente(idCliente);
  }

  
  public int getId() {
  	return idPedido;
  }
		
  public void setIdPedido(Cliente cliente) {
		int tamanho = cliente.getHistoricoPedidos().size();
		this.idPedido = tamanho;
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

  public String toString() {
	  return "{Pedido itens: " + itens + ", valor: " + valor + ", idCliente: " + idCliente + ", data : " + data + "}";
  }
}
