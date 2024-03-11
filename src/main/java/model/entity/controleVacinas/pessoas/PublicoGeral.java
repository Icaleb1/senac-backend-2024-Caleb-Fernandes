package model.entity.controleVacinas.pessoas;

import java.time.LocalDate;

public class PublicoGeral extends Pessoa{

	public PublicoGeral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PublicoGeral(int id, String nome, LocalDate dataNascimento,
			model.entity.controleVacinas.enumerador.Sexo sexo, String cpf,
			model.entity.controleVacinas.enumerador.TipoPessoa tipoPessoa, int avaliacao) {
		super(id, nome, dataNascimento, sexo, cpf, tipoPessoa, avaliacao);
		// TODO Auto-generated constructor stub
	}

	
	

}
