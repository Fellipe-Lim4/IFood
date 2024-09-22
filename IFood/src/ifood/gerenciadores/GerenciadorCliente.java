package ifood.gerenciadores;    // Mudar o nome do diretó/rio para ifood.gerenciadores.
import ifood.usuarios.Cliente;
import java.util.List;

public class GerenciadorCliente {
  private List<Cliente> clientes;

  public GerenciadorCliente() {
    this.clientes = new List<Cliente>();
  }
  
  // Adiciona cliente
  public void criarCliente (String nome, String email, String senha, String telefone, 
						String endereco, String cnpj, String sexo, String dataNascimento) {
    Cliente novoCliente = new Cliente (nome, email, senha, telefone, endereco, cnpj, sexo, dataNascimento);

    novoCliente.setNome(nome);
    novoCliente.setEmail(email);
    novoCliente.setSenha(senha);
	novoCliente.setTelefone(telefone);
	novoCliente.setEndereco(endereco);
	novoCliente.setCnpj(cnpj);
	novoCliente.setSexo(sexo);
	novoCliente.setDataNascimento(dataNascimento);
		
    this.clientes.add(novoCliente);
  }
  
  // Remove cliente
  public void removerCliente(Cliente novoCliente) {
    this.clientes.remove(novoCliente);
  }

  // Imprime lista de clientes
  public void exibirClientes() {
    for (Cliente clientes: this.clientes) {
      System.out.println(clientes.toString());
  }
  
  
  // Operações de login a ser implementado
}
