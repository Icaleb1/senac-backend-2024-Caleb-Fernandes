package model.entity.controleVacinas;

import java.time.LocalDate;

import model.entity.controleVacinas.enumerador.EstagioPesquisa;
import model.entity.controleVacinas.pessoas.Pesquisador;

public class Vacina {
	
	private String paisOrigem;
	private EstagioPesquisa estagioPesquisa;
	private LocalDate dataInicio;
	private String pesquisadorResponsavel;
	
	public Vacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vacina(String paisOrigem, EstagioPesquisa estagioPesquisa, LocalDate dataInicio,
			String pesquisadorResponsavel) {
		super();
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicio = dataInicio;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}

	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	
	

}
