package ifood.usuarios;

public abstract class Usuario {
	  private String nome;
	  private String email;
	  private String senha;
	  private String telefone;
	  private String endereco;
	  private String cnpj;

	  public String getNome() {
	    return nome;
	  }
	  public void setNome(String nome) {
	    this.nome = nome;
	  }
	  public String getEndereco() {
	    return endereco;
	  }
	  public void setEndereco(String endereco) {
	    this.endereco = endereco;
	  }
	  public String getTelefone() {
	    return telefone;
	  }
	  public void setTelefone(String telefone) {
	    this.telefone = telefone;
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

	  @Override
	  public String toString() {
	    return "Usuario{" +
	        "nome='" + nome + '\'' +
	        ", endereco='" + endereco + '\'' +
	        ", telefone='" + telefone + '\'' +
	        ", email='" + email + '\'' +
	        ", cnpj='" + cnpj + '\'' +
	        '}';
	  }
	}