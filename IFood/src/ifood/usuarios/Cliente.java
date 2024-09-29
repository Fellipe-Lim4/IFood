package ifood.usuarios;

import java.util.List;
import java.util.ArrayList;

import ifood.gerenciadores.GerenciadorCliente;
import ifood.produtos.ItensPedido;
import ifood.produtos.*;

public class Cliente extends Usuario {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
    private String sexo;
    private String dataNascimento;
    private List<Pedido> HistoricoPedidos = new ArrayList<>();
    private int Id;


    public Cliente (String nome, String email, String senha, String telefone, String endereco, String sexo, String dataNascimento, GerenciadorCliente gerenciador) {
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.telefone = telefone;
      this.endereco = endereco;
      this.sexo = sexo;
      this.dataNascimento = dataNascimento;
      setId(gerenciador);
    }
    
    public int getId() {
    	return Id;
    }
		
    private void setId(GerenciadorCliente gerenciador) {
		int tamanho = gerenciador.getClientes().size();
		this.Id = tamanho;
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


    public Pedido realizaPedido(double valor) {      
      List<ItensPedido> listaItens = new ArrayList<ItensPedido>();
      Pedido pedido = new Pedido(listaItens, valor, getId());
      
      return pedido;
    }

	@Override
	public String toString() {
		return "Cliente [nome=" + getNome() + ", endereco=" + getEndereco() + ", telefone="
				+ getTelefone() + ", email=" + getEmail() + ", senha=" + getSenha() + ", cnpj="
				+ getCnpj() + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + "]";
	}



	public List<Pedido> getHistoricoPedidos() {
		return HistoricoPedidos;
	}



	public void setHistoricoPedidos(List<Pedido> historicoPedidos) {
		HistoricoPedidos = historicoPedidos;
	}

	

}
