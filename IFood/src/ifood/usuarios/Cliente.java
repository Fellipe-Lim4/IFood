package ifood.usuarios;

import java.util.List;
import java.util.ArrayList;
import ifood.produtos.*;


public class Cliente extends Usuario {
    private String sexo;
    private String dataNascimento;
    private Cupom cupomDesconto;

    public Cliente (String nome, String email, String senha, String telefone, String endereco, String cnpj, String sexo, String dataNascimento) {
      super();    // Chamada ao construtor da superclasse para outros atrib
      this.sexo = sexo;
      this.dataNascimento = dataNascimento;
    }
		
    public String getSexo() {
      return sexo;
    }

    public void setSexo(String sexo) {
      this.sexo = sexo;
    }

    public String getDataNascimento() {
      return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
      this.dataNascimento = dataNascimento;
    }

    public Pedido realizaPedido() {      
      List<Produto> listaItens = new ArrayList<Produto>();
      listaItens.add(new Produto("Pizza", "Pizza de calabresa", 50.0)); 
      listaItens.add(new Produto("Sanduiche", "Sanduiche de carne", 15.0));// O cliente escolhe os item do pedido. É bom substituir essa 
      																	// parte por algo mais interativo talvez.
      cupomDesconto = new Cupom(0, 0.15);			// Adicionando um cupom de 15%
      
      System.out.println("Realizando pedido...");
      Pedido pedido = new Pedido(listaItens, cupomDesconto);		// Pedido recebe a lista de produtos e o cupom
      
      return pedido;
    }

	@Override
	public String toString() {
		return "Cliente [nome=" + getNome() + ", endereco=" + getEndereco() + ", telefone="
				+ getTelefone() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cnpj="
				+ getCnpj() + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + "]";
	}

	

}
