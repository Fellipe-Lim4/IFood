package ifood.produtos;

import java.time.LocalDate;

public class Cupom {
	private double valor;
	private double porcentagem;
	private String codAtivacao;
	private LocalDate dataExpiracao;
	private boolean freteGratis;
	
	public Cupom(String codAtivacao ,double valor, double porcentagem, LocalDate dataExpiracao, boolean freteGratis) {
		this.codAtivacao = codAtivacao;
		this.valor = valor;
		this.porcentagem = porcentagem;
		this.dataExpiracao = dataExpiracao;
		this.freteGratis = freteGratis;
	}
	
	public boolean isFreteGratis() {
		return freteGratis;
	}



	public void setFreteGratis(boolean freteGratis) {
		this.freteGratis = freteGratis;
	}



	public LocalDate getDataExpiracao() {
		return dataExpiracao;
	}



	public void setDataExpiracao(LocalDate dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}



	public String getCodAtivacao() {
		return codAtivacao;
	}


	public void setCodAtivacao(String codAtivacao) {
		this.codAtivacao = codAtivacao;
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

	@Override
	public String toString() {
		return "Cupom [valor=" + valor + ", porcentagem=" + porcentagem + ", codAtivacao=" + codAtivacao
				+ ", dataExpiracao=" + dataExpiracao + ", freteGratis=" + freteGratis + "]";
	}
	
	
}