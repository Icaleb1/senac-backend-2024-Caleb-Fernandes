package service.controleVacinas;

import java.time.LocalDate;
import java.util.ArrayList;

import exception.controleVacinas.ControleVacinasException;
import model.entity.controleVacinas.Pessoa;
import model.entity.controleVacinas.Vacina;
import model.entity.controleVacinas.Vacinacao;
import model.repository.controleVacinas.VacinacaoRepository;

public class VacinacaoService {
	
	private static final int NOTA_MAXIMA=5;
	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	
	public Vacinacao salvar(Vacinacao novaVacinacao) throws ControleVacinasException{
		
		if(novaVacinacao.getIdPessoa() == 0 
				|| novaVacinacao.getVacina() == null
				|| novaVacinacao.getVacina().getId() == 0) {
			throw new ControleVacinasException("Informe a o id da pessoa e a vacina da aplicação");
		}
		
		novaVacinacao.setDataAplicacao(LocalDate.now());
		
		if(novaVacinacao.getAvaliacao() == 0) {
			novaVacinacao.setAvaliacao(NOTA_MAXIMA);
		}
		
		return  vacinacaoRepository.salvar(novaVacinacao);
		
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
	
	public void receberVacina(Vacinacao vacinacao) {
		Pessoa pessoa = new Pessoa();
		Vacina vacina = new Vacina();
		String mensagemValidacao = "";
		
		switch(vacina.getEstagioPesquisa()) {
		case 1: 
			if(pessoa.getTipoPessoa() != 1) {
				mensagemValidacao = " Estágio inicial somente para pesquisadores";
			};
		break;
		case 2:
			if(pessoa.getTipoPessoa() != 1 || pessoa.getTipoPessoa() != 2) {
				mensagemValidacao = "Estágio de teste somente para pesquisadores ou voluntários";
			}
		break;
		}
		
		
		
	}
}
