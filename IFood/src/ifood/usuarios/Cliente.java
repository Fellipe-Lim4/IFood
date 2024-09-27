package ifood.usuarios;

import java.util.List;
import java.util.ArrayList;
import ifood.produtos.Item;
import ifood.produtos.Pedido;

public class Cliente extends Usuario {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
    private String sexo;
    private String dataNascimento;

    public Cliente (String nome, String email, String senha, String telefone, String endereco, String sexo, String dataNascimento) {
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.telefone = telefone;
      this.endereco = endereco;
      this.sexo = sexo;
      this.dataNascimento = dataNascimento;
    }
    
    
		
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
      List<Item> listaItens = new ArrayList<Item>();
      listaItens.add(new Item("Pizza", "Pizza de calabresa", 50.0)); 
      listaItens.add(new Item("Sanduiche", "Sanduiche de carne", 15.0));// O cliente escolhe os item do pedido
      
      System.out.println("Realizando pedido...");
      Pedido pedido = new Pedido(listaItens);
      
      return pedido;
    }

	@Override
	public String toString() {
		return "Cliente [nome=" + getNome() + ", endereco=" + getEndereco() + ", telefone="
				+ getTelefone() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cnpj="
				+ getCnpj() + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + "]";
	}

	

}
