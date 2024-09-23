package ifood.produtos;

public class Produto extends Item {
    public Produto(String nome, String descricao, double preco) {
        super(nome, descricao, preco);
    }
    
    public String toString() {
    	return super.toString();
    }
}