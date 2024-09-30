package ifood.produtos;


import ifood.usuarios.Restaurante;

public class Produto extends ItensPedido {
	int produtoId;
	Restaurante restaurante;
	

	public Produto(String nome, String descricao, double preco, Restaurante restaurante) {
        super(nome, descricao, preco);
        this.restaurante = restaurante;
    }
    
	public int getProdutoId() {
		return produtoId;
	}
	
	
	public void setProdutoId(Restaurante restaurante) {
		int tamanho = restaurante.getProdutos().size();
		this.produtoId = tamanho;
	}
	
    
    public String toString() {
    	return super.toString();
    }
    
    
    public Restaurante getRestaurante() {
    	return restaurante;
    }
    
    public void setRestaurante(Restaurante restaurante) {
    	this.restaurante = restaurante;
    }
}