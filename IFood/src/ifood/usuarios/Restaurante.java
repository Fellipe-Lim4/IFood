package ifood.usuarios;

import ifood.produtos.Produto;
import java.util.List;

public class Restaurante extends Usuario {

  private String cnpj;

  private List<Produto> produtos;

  public Restaurante(String cnpj) {
    this.cnpj = cnpj;
  }

  public void adicionaPrato(Produto prato) {
    this.produtos.add(prato);
  }
  public void removePrato(Produto prato) {
    this.produtos.remove(prato);
  }
  public List<Produto> getPratos() {
    return this.produtos;
  }

  public void exibePratos() {
    for(Produto prato : this.produtos) {
      System.out.println(prato.toString());
    }
  }
  
  public String getCnpj() {
    return cnpj;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

@Override
public String toString() {
	return super.toString() + ", Restaurante [cnpj=" + cnpj + ", produtos=" + produtos + "]";
}
  
  
}