package model.entity.controleVacinas;

public class Pais {

	private int id;
	private String nome;
	private String sigla;
	
	
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pais(String nome, String sigla, int id) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
