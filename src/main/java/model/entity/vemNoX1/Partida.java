package model.entity.vemNoX1;

import java.time.LocalDateTime;
import java.util.List;

public class Partida {
	
	private int id;
	private Jogador jogador;
	private List<CartaNaPartida> cartasDoJogador;
	private List<CartaNaPartida> cartasCpu;
	private int roundsVencidosJogador;
	private int roundsVencidosCpu;
	private int roundsEmpatados;
	private Resultado resultado;
	private LocalDateTime data;
	private boolean jogouForca;
	private boolean jogouInteligencia;
	private boolean jogouVelocidade;
	
	public Partida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partida(int id, Jogador jogador, List<CartaNaPartida> cartasDoJogador, List<CartaNaPartida> cartasCpu,
			int roundsVencidosJogador, int roundsVencidosCpu, int roundsEmpatados, Resultado resultado,
			LocalDateTime data, boolean jogouForca, boolean jogouInteligencia, boolean jogouVelocidade) {
		super();
		this.id = id;
		this.jogador = jogador;
		this.cartasDoJogador = cartasDoJogador;
		this.cartasCpu = cartasCpu;
		this.roundsVencidosJogador = roundsVencidosJogador;
		this.roundsVencidosCpu = roundsVencidosCpu;
		this.roundsEmpatados = roundsEmpatados;
		this.resultado = resultado;
		this.data = data;
		this.jogouForca = jogouForca;
		this.jogouInteligencia = jogouInteligencia;
		this.jogouVelocidade = jogouVelocidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<CartaNaPartida> getCartasDoJogador() {
		return cartasDoJogador;
	}

	public void setCartasDoJogador(List<CartaNaPartida> cartasDoJogador) {
		this.cartasDoJogador = cartasDoJogador;
	}

	public List<CartaNaPartida> getCartasCpu() {
		return cartasCpu;
	}

	public void setCartasCpu(List<CartaNaPartida> cartasCpu) {
		this.cartasCpu = cartasCpu;
	}

	public int getRoundsVencidosJogador() {
		return roundsVencidosJogador;
	}

	public void setRoundsVencidosJogador(int roundsVencidosJogador) {
		this.roundsVencidosJogador = roundsVencidosJogador;
	}

	public int getRoundsVencidosCpu() {
		return roundsVencidosCpu;
	}

	public void setRoundsVencidosCpu(int roundsVencidosCpu) {
		this.roundsVencidosCpu = roundsVencidosCpu;
	}

	public int getRoundsEmpatados() {
		return roundsEmpatados;
	}

	public void setRoundsEmpatados(int roundsEmpatados) {
		this.roundsEmpatados = roundsEmpatados;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isJogouForca() {
		return jogouForca;
	}

	public void setJogouForca(boolean jogouForca) {
		this.jogouForca = jogouForca;
	}

	public boolean isJogouInteligencia() {
		return jogouInteligencia;
	}

	public void setJogouInteligencia(boolean jogouInteligencia) {
		this.jogouInteligencia = jogouInteligencia;
	}

	public boolean isJogouVelocidade() {
		return jogouVelocidade;
	}

	public void setJogouVelocidade(boolean jogouVelocidade) {
		this.jogouVelocidade = jogouVelocidade;
	}
	
	

}
