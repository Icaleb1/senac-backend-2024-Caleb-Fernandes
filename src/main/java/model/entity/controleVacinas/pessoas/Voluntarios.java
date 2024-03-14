package model.entity.controleVacinas.pessoas;

import java.time.LocalDate;

public class Voluntarios extends Pessoa{

	public Voluntarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voluntarios(int id, String nome, LocalDate dataNascimento, model.entity.controleVacinas.enumerador.Sexo sexo,
			String cpf, model.entity.controleVacinas.enumerador.TipoPessoa tipoPessoa, int avaliacao) {
		super(id, nome, dataNascimento, sexo, cpf, tipoPessoa);
		// TODO Auto-generated constructor stub
	}

	
	

}
