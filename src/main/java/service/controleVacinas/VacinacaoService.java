package service.controleVacinas;

import java.util.ArrayList;

import model.entity.controleVacinas.Vacinacao;
import model.repository.controleVacinas.VacinacaoRepository;

public class VacinacaoService {
	
	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	
	public Vacinacao salvar(Vacinacao vacinacao) {
		return  vacinacaoRepository.salvar(vacinacao);
		
	}
	
	public boolean alterar(Vacinacao vacinacao) {
		return vacinacaoRepository.alterar(vacinacao);
	}
	
	public boolean excluir(int id) {
		return vacinacaoRepository.excluir(id);
	}
	
	public Vacinacao consultarPorId(int id) {
		return vacinacaoRepository.consultarPorId(id);
	}

	public ArrayList<Vacinacao> consultarTodos(){
		return vacinacaoRepository.consultarTodos();
	}
	

}
