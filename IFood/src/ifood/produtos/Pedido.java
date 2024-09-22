package ifood.produtos;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
  private List<Item> itens;
  private LocalDate data = LocalDate.now();

  public Pedido(List<Item> itens) {
    this.itens = itens;
  }
}
