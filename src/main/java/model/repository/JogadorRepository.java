package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.entity.Jogador;

public class JogadorRepository implements BaseRepository<Jogador>{

	@Override
	public Jogador salvar(Jogador novoJogador) {
		String query = "INSERT INTO jogador (nome, email, data_nascimento, total_partidas, percentual_vitorias) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement psmt = Banco.getPreparedStatement(conn, query);
		try {
			//TODO este bloco repete-se no alterar().... refatorar!
			psmt.setString(1, novoJogador.getNome());
			psmt.setString(2, novoJogador.getEmail());
			psmt.setDate(3, Date.valueOf(novoJogador.getDataNascimento()));
			psmt.setInt(4, novoJogador.getTotalPartidas());
			psmt.setDouble(5, novoJogador.getPercentualVitorias());
			
			psmt.execute();
			ResultSet resultado = psmt.getGeneratedKeys();
			
			if (resultado.next()) {
				novoJogador.setId(resultado.getInt(1));
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao salvar novo jogador");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(psmt);
			Banco.closeConnection(conn);
		}
		
		return novoJogador;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Jogador entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Jogador consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jogador> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
