package model.entity.controleVacinas.pessoas;

import java.time.LocalDate;

import model.entity.controleVacinas.enumerador.Sexo;
import model.entity.controleVacinas.enumerador.TipoPessoa;

public class Pessoa {
	
	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private Sexo sexo;
	private String cpf;
	private TipoPessoa tipoPessoa;
	private int avaliacao;
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(int id, String nome, LocalDate dataNascimento, model.entity.controleVacinas.enumerador.Sexo sexo,
			String cpf, model.entity.controleVacinas.enumerador.TipoPessoa tipoPessoa, int avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
		this.avaliacao = avaliacao;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
	

}
