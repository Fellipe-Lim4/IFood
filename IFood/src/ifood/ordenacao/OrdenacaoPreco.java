package ifood.ordenacao;
import java.util.Comparator;

import ifood.usuarios.Restaurante;

public class OrdenacaoPreco implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante r1, Restaurante r2) {
		if(r1.getMediaPreco()<r2.getMediaPreco()) {
			return -1;
		}
		if(r1.getMediaPreco()>r2.getMediaPreco()) {
			return 1;
		}
		return 0;
	}

}
