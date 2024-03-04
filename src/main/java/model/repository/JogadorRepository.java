package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.entity.Jogador;

public class JogadorRepository implements BaseRepository<Jogador>{

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

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM jogador WHERE id = " + id; 
		try {
			if (stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir jogador");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	public boolean alterar(Jogador novoJogador) {
		boolean alterou = false;
		String query = "UPDATE jogador SET nome = ?, email = ?, data_nascimento = ?, total_partidas = ?, percentual_vitorias = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			//TODO este bloco repete-se no salvar().... refatorar!
			pstmt.setString(1, novoJogador.getNome());
			pstmt.setString(2, novoJogador.getEmail());
			pstmt.setDate(3, Date.valueOf(novoJogador.getDataNascimento()));
			pstmt.setInt(4, novoJogador.getTotalPartidas());
			pstmt.setDouble(5, novoJogador.getPercentualVitorias());
			
			alterou = pstmt.executeUpdate(query) == 1;
		} catch (SQLException erro) {
			System.out.println("Erro ao atualizar jogador");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return alterou;
	}

	public Jogador consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		Jogador jogador = new Jogador();
		String query = "SELECT * FROM jogador WHERE id = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				//TODO este bloco repete-se no consultarTodos().... refatorar!
				jogador.setId(Integer.parseInt(resultado.getString("ID")));
				jogador.setNome(resultado.getString("NOME"));
				jogador.setEmail(resultado.getString("EMAIL"));
				jogador.setDataNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate());
				jogador.setTotalPartidas(resultado.getInt("TOTAL_PARTIDAS"));
				jogador.setPercentualVitorias(resultado.getDouble("PERCENTUAL_VITORIAS"));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar jogador com id (" + id + ")");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return jogador;
	}

	public ArrayList<Jogador> consultarTodos() {
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = "SELECT * FROM jogador";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				Jogador jogador = new Jogador();
				
				//TODO este bloco repete-se no consultarTodos().... refatorar!
				jogador.setId(Integer.parseInt(resultado.getString("ID")));
				jogador.setNome(resultado.getString("NOME"));
				jogador.setEmail(resultado.getString("EMAIL"));
				jogador.setDataNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate()); 
				jogador.setTotalPartidas(resultado.getInt("TOTAL_PARTIDAS"));
				jogador.setPercentualVitorias(resultado.getInt("PERCENTUAL_VITORIAS"));
				jogadores.add(jogador);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todas as jogadors");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return jogadores;
	}

}
