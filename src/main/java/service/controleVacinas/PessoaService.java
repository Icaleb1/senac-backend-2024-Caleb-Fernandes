package service.controleVacinas;

import java.util.List;

import exception.controleVacinas.controleVacinasException;
import model.entity.controleVacinas.pessoas.Pessoa;
import model.repository.controleVacinas.PessoaRepository;

public class PessoaService {

	private PessoaRepository repository = new PessoaRepository();
	
	public Pessoa salvar(Pessoa novaPessoa) throws controleVacinasException { 
		return repository.salvar(novaPessoa);
	}
	
	public boolean excluir(int id) {
		return repository.excluir(id);
	}
	
	public List<Pessoa> consultarTodas(){
		return repository.consultarTodas();
	}
	
	
}
	