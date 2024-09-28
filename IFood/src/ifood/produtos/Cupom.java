package ifood.produtos;

public class Cupom {
	private double valor;
	private double porcentagem;
	
	
	public Cupom(double valor, double porcentagem) {
		this.valor = valor;
		this.porcentagem = porcentagem;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}	
}
