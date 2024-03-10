package model.entity.controleVacinas;

import java.time.LocalDate;

import model.entity.controleVacinas.pessoas.Pessoa;

public class AplicacaoVacina {
	
	private LocalDate dataAplicacao;
	private Pessoa pessoaVacinada;
	
	public AplicacaoVacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AplicacaoVacina(LocalDate dataAplicacao, Pessoa pessoaVacinada) {
		super();
		this.dataAplicacao = dataAplicacao;
		this.pessoaVacinada = pessoaVacinada;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public Pessoa getPessoaVacinada() {
		return pessoaVacinada;
	}

	public void setPessoaVacinada(Pessoa pessoaVacinada) {
		this.pessoaVacinada = pessoaVacinada;
	} 
	
	

}
