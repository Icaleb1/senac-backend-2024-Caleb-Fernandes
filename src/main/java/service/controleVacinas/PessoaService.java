package service.controleVacinas;

import java.util.List;

import exception.controleVacinas.ControleVacinasException;
import model.entity.controleVacinas.Pessoa;
import model.entity.controleVacinas.Vacinacao;
import model.repository.controleVacinas.PessoaRepository;
import model.repository.controleVacinas.VacinacaoRepository;

public class PessoaService {

	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	private PessoaRepository repository = new PessoaRepository();
	
	public Pessoa salvar(Pessoa novaPessoa) throws ControleVacinasException {
		validarCamposObrigatorios(novaPessoa);
		
		validarCpf(novaPessoa);
		
		return repository.salvar(novaPessoa);
	}
	
	public boolean alterar(Pessoa pessoaEditada) throws ControleVacinasException{
		validarCamposObrigatorios(pessoaEditada);
		
		return repository.alterar(pessoaEditada);
	}
	
	private void validarCamposObrigatorios(Pessoa pessoa) throws ControleVacinasException {
		String mensagemValidacao = "";
	
		
		
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			mensagemValidacao += "- informe o nome \n";
		}
		
		if (pessoa.getDataNascimento() == null) {
			mensagemValidacao += "- informe a data de nascimento \n";
		}
		
		if (pessoa.getCpf() == null || pessoa.getCpf().isEmpty() || pessoa.getCpf().length() != 11) {
			mensagemValidacao += "- informe o CPF";
		}
		
		if (pessoa.getSexo() == ' ' ) {
			mensagemValidacao += "- informe o sexo";
		}
		
		if (pessoa.getTipoPessoa() < 1 || pessoa.getTipoPessoa() > 3) {
			mensagemValidacao += "- informe o tipo entre (1 e 3)";
		}
		
		if (pessoa.getPais() == null) {
			mensagemValidacao += "- informe o pais: ";
		}
		
		if (!mensagemValidacao.isEmpty()) {
			throw new ControleVacinasException("Preencha o(s) seguinte(s) campo(s) \n " + mensagemValidacao);
			
		}
		
	}
	
	private void validarCpf(Pessoa novaPessoa) throws ControleVacinasException{
		if (repository.cpfJaCadastrado(novaPessoa.getCpf())) {
			throw new ControleVacinasException("CPF" + novaPessoa.getCpf() + " já cadastrado");
		}
	}
	
	public boolean excluir(int id) throws ControleVacinasException {
		verificarVacinacaoPessoa(id);
		
		return repository.excluir(id);
	}
	
	public List<Pessoa> consultarTodas(){
		return repository.consultarTodos();
	}
	
	
	public Pessoa consultarPorId(int id) {
		return repository.consultarPorId(id);
	}
	
	private void verificarVacinacaoPessoa(int id) throws ControleVacinasException{
		String mensagemValidacao = "";
		if(!vacinacaoRepository.consultarPorIdPessoa(id).isEmpty()) {
			throw new ControleVacinasException("Pessoa já vacinada! ");
		}
	}
	
}
	