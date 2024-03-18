package model.entity.controleVacinas;

import java.time.LocalDate;

import model.entity.controleVacinas.pessoas.Pessoa;

public class Vacinacao {
	
	private int id;
	private int idPessoa;
	private int idVacina;
	private LocalDate data;
	private int avaliacao;
	
	
	public Vacinacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vacinacao(int id, int idPessoa, int idVacina, LocalDate data, int avaliacao) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.idVacina = idVacina;
		this.data = data;
		this.avaliacao = avaliacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getVacina() {
		return idVacina;
	}

	public void setVacina(int idVacina) {
		this.idVacina = idVacina;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	

}
