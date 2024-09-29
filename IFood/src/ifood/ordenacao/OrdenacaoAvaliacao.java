package ifood.ordenacao;
import java.util.Comparator;

import ifood.usuarios.Restaurante;

public class OrdenacaoAvaliacao implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante r1, Restaurante r2) {
		if(r1.getMediaAvaliacoes()>r2.getMediaAvaliacoes()) {
			return -1;
		}
		if(r1.getMediaAvaliacoes()<r2.getMediaAvaliacoes()) {
			return 1;
		}
		return 0;
	}

}
