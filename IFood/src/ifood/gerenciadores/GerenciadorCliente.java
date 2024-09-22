package ifood.gerenciadores;    // Mudar o nome do diretó/rio para ifood.gerenciadores.
import ifood.usuarios.Cliente;
import java.util.List;

public class GerenciadorCliente {
  private List<Cliente> clientes;

  public GerenciadorCliente() {
    //this.clientes = List<Cliente>();
  }
  
  // Adiciona cliente
  /*public void criarCliente (String cnpj, String nome, String email, String senha) {
    Cliente novoCliente = new Cliente (cnpj);

    novoCliente.setNome(nome);
    novoCliente.setEmail(email);
    novoCliente.setSenha(senha);

    this.clientes.add(novoCliente);
  }
  */
  // Remove cliente
  public void removerCliente(Cliente novoCliente) {
    this.clientes.remove(novoCliente);
  }

  // Operações de login
  /*
  public boolean realizarLogin(Cliente novoCliente) {
    if (novoCliente.getEmail().equals(this.clientes.getEmail()) && novoCliente.getSenha().equals(this.clientes.getSenha())) {
      return true;
    } else {
      return false;
    }
  }
  */
}