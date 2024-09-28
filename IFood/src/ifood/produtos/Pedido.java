package ifood.produtos;
import java.time.LocalDate;
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

  public String toString() {
	  return "itens: " + itens + ", valor: " + valor + ", idCliente: " + idCliente + ", data : " + data;

  private LocalDate data = LocalDate.now();
  private double total;
  private double desconto;

  public Pedido(List<Produto> produtos, Cupom cupomDesconto) {
    this.produtos = produtos;
    this.desconto = cupomDesconto.getPorcentagem();

  }
    
  public List<Produto> getProdutos() {
	return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
	this.produtos = produtos;
  }

  public LocalDate getData() {
	return data;
  }

  public void setData(LocalDate data) {
	this.data = data;
  }

  public double getTotal() {
	return total;
  }

  public void setTotal(double total) {
	this.total = total;
  }


public void verificaPreco() {
	  for(Produto produtos:this.produtos) {
		  this.total += produtos.getPreco(); 		// Soma os preços dos itens individuais
	  }
	  this.total -= desconto;
  }

  @Override
  public String toString() {				// Para imprimir os dados do pedido
	  return "Pedido [itens=" + itens + ", data=" + data + ", total=" + total + "]";
  }
    
}
