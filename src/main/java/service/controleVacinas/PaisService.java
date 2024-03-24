package service.controleVacinas;

import model.entity.controleVacinas.Pais;
import model.repository.controleVacinas.PaisRepository;

public class PaisService {

	
	private PaisRepository repository = new PaisRepository();
	
	
	public Pais salvar(Pais novoPai) {
		return repository.salvar(novoPai);
	}
}
