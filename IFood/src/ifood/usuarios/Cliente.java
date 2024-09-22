package ifood.usuarios;

import java.util.List;
import java.util.ArrayList;
import ifood.produtos.Item;
import ifood.produtos.Pedido;

public class Cliente extends Usuario {
    private String sexo;
    private String dataNascimento;

    public Cliente (String sexo, String dataNascimento) {
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

    public void realizaPedido() {      
      List<Item> listaItens = new ArrayList<Item>();
      listaItens.add(new Item("Pizza", "Pizza de calabresa", 50.0)); 
      listaItens.add(new Item("Sanduiche", "Sanduiche de carne", 15.0));// O cliente escolhe os item do pedido
      
      System.out.println("Realizando pedido...");
      Pedido pedido = new Pedido(listaItens);
    }

}