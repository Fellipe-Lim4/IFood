package ifood.ordenacao;
import java.util.Comparator;

import ifood.usuarios.Restaurante;

public class OrdenacaoTaxaEntrega implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante r1, Restaurante r2) {
		if(r1.getTaxaEntrega()<r2.getTaxaEntrega()) {
			return -1;
		}
		if(r1.getTaxaEntrega()>r2.getTaxaEntrega()) {
			return 1;
		}
		return 0;
	}

}
