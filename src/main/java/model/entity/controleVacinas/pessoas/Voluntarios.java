package model.entity.controleVacinas.pessoas;

import java.time.LocalDate;

public class Voluntarios extends Pessoa{

	public Voluntarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voluntarios(int id, String nome, LocalDate dataNascimento, model.entity.controleVacinas.enumerador.sexo sexo,
			String cpf, model.entity.controleVacinas.enumerador.tipoPessoa tipoPessoa, int avaliacao) {
		super(id, nome, dataNascimento, sexo, cpf, tipoPessoa, avaliacao);
		// TODO Auto-generated constructor stub
	}

	
	

}
