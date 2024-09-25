package ifood.produtos;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
  private List<Produto> produtos;
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
	  return "Pedido [itens=" + produtos + ", data=" + data + ", total=" + total + "]";
  }
    
}
