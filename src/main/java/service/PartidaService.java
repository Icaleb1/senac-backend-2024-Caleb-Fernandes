package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.dto.JogadaDTO;
import model.dto.PartidaDTO;
import model.entity.Resultado;
import model.entity.Carta;
import model.entity.CartaNaPartida;
import model.entity.Partida;
import model.repository.CartaPartidaRepository;
import model.repository.CartaRepository;
import model.repository.JogadorRepository;
import model.repository.PartidaRepository;

public class PartidaService {

	private JogadorRepository jogadorRepository = new JogadorRepository();
	private PartidaRepository partidaRepository = new PartidaRepository();
	private CartaRepository cartaRepository = new CartaRepository();
	private CartaPartidaRepository cartaPartidaRepository = new CartaPartidaRepository();
	
	public PartidaDTO iniciarPartida(int idJogador) {
		PartidaDTO dto = new PartidaDTO();
		
		//Criar uma partida -> inserir Partida [PartidaRepository]
		Partida novaPartida = new Partida();
		novaPartida.setResultado(Resultado.EM_ANDAMENTO);
		novaPartida.setData(LocalDateTime.now());
		novaPartida.setJogador(jogadorRepository.consultarPorId(idJogador));
		novaPartida = partidaRepository.salvar(novaPartida);
		
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add("Força");
		atributos.add("Inteligência");
		atributos.add("Velocidade");
		
		//Sortear as 6 cartas -> sortearCartas [CartaRepository]
		ArrayList<Carta> seisCartas = cartaRepository.sortearSeisCartas();
		ArrayList<CartaNaPartida> cartasDoJogador = new ArrayList<CartaNaPartida>();
		
		//Distribuir para jogador e CPU -> inserir CartaPartida
		boolean ehDoJogador = true;
		for(Carta carta : seisCartas) {
			CartaNaPartida cartaDaPartida = new CartaNaPartida();
			cartaDaPartida.setIdPartida(novaPartida.getId());
			cartaDaPartida.setCarta(carta);
			cartaDaPartida.setPertenceAoJogador(ehDoJogador);
			cartaDaPartida = cartaPartidaRepository.salvar(cartaDaPartida);
			
			if(ehDoJogador) {
				cartasDoJogador.add(cartaDaPartida);
			}
			
			//Exclamação é operador de NEGAÇÃO
			//Usado para intercalar a distribuição de cartas entre jogador e CPU
			ehDoJogador = !ehDoJogador;
		}
		
		//Montar o PartidaDTO e retornar 
		dto.setIdPartida(novaPartida.getId());
		dto.setResultadoUltimaJogada(null);
		dto.setAtributosDisponiveis(atributos);
		dto.setCartasJogador(cartasDoJogador);
		return dto;
	}

	public PartidaDTO jogar(JogadaDTO jogada) {
		PartidaDTO partidaAtualizada = new PartidaDTO();
		Partida partida = partidaRepository.consultarPorId(jogada.getIdPartida());
		CartaNaPartida cartaJogada = cartaPartidaRepository.consultarPorId(jogada.getIdCartaNaPartidaSelecionada());
		
		if(jogada.getAtributoSelecionado() == "Força") {
			int valorForca = cartaJogada.getCarta().getForca();
			//TODO continuar
			
		}
		
		
		return partidaAtualizada;
	}

}
