package model.entity;

public class CartaNaPartida {
	
	private int id;
	private int idPrivate;
	private Carta carta;
	private boolean pertenceAoJogador;
	private boolean utilizada;
	
	public CartaNaPartida() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartaNaPartida(int id, int idPrivate, Carta carta, boolean pertenceAoJogador, boolean utilizada) {
		super();
		this.id = id;
		this.idPrivate = idPrivate;
		this.carta = carta;
		this.pertenceAoJogador = pertenceAoJogador;
		this.utilizada = utilizada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPrivate() {
		return idPrivate;
	}
	public void setIdPrivate(int idPrivate) {
		this.idPrivate = idPrivate;
	}
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	public boolean isPertenceAoJogador() {
		return pertenceAoJogador;
	}
	public void setPertenceAoJogador(boolean pertenceAoJogador) {
		this.pertenceAoJogador = pertenceAoJogador;
	}
	public boolean isUtilizada() {
		return utilizada;
	}
	public void setUtilizada(boolean utilizada) {
		this.utilizada = utilizada;
	}
	
	

}
