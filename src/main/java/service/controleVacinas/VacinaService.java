package service.controleVacinas;

import java.util.ArrayList;
import java.util.List;

import exception.controleVacinas.ControleVacinasException;
import model.entity.controleVacinas.Vacina;
import model.entity.controleVacinas.Vacinacao;
import model.repository.controleVacinas.VacinaRepository;
import model.repository.controleVacinas.VacinacaoRepository;

public class VacinaService {

	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	private VacinaRepository repository = new VacinaRepository();
	
	public Vacina salvar(Vacina novaVacina){
		mediaVacina(novaVacina);
		
		return repository.salvar(novaVacina);
	}

	public boolean atualizar(Vacina vacinaEditada) {
		return repository.alterar(vacinaEditada);
	}

	public boolean excluir(int id) throws ControleVacinasException {
		verificarVacinacaoVacina(id);
		return repository.excluir(id);
	}

	public Vacina consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public List<Vacina> consultarTodas() {
		return repository.consultarTodos();
	}

	private void verificarVacinacaoVacina(int id) throws ControleVacinasException{
		String mensagemValidacao = "";
		if(!vacinacaoRepository.consultarPorIdVacina(id).isEmpty()) {
			throw new ControleVacinasException("Vacina já aplicada! ");
		}
	}

	private double mediaVacina(Vacina vacina) {
		Vacinacao vacinacao2 = new Vacinacao();
		int soma = 0;
		
		ArrayList<Vacinacao> aplicacoesDaVacina = vacinacaoRepository.consultarPorIdVacina(vacina.getId());
		
		for (Vacinacao vacinacao : aplicacoesDaVacina) {
			soma += vacinacao.getAvaliacao();
		}
		
		double media = soma/vacinacao2.getId();
		
		return media;
		
	}
	
}

