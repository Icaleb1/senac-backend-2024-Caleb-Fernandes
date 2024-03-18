package model.entity.controleVacinas;

import java.time.LocalDate;

import model.entity.controleVacinas.enumerador.EstagioPesquisa;
import model.entity.controleVacinas.pessoas.Pesquisador;
import model.entity.controleVacinas.pessoas.Pessoa;

public class Vacina {
	
	private int id;
	private String nome;
	private String paisOrigem;
	private EstagioPesquisa estagioPesquisa;
	private int idPesquisador;
	private LocalDate dataInicio;
	
	public Vacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vacina(int id, String nome, String paisOrigem, EstagioPesquisa estagioPesquisa,
			int pesquisadorResponsavel, LocalDate dataInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.idPesquisador = pesquisadorResponsavel;
		this.dataInicio = dataInicio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public EstagioPesquisa getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(EstagioPesquisa estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public int getPesquisadorResponsavel() {
		return idPesquisador;
	}

	public void setPesquisadorResponsavel(int pesquisadorResponsavel) {
		this.idPesquisador = pesquisadorResponsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	

}
