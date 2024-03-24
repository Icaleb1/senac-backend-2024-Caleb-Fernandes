package model.repository.controleVacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.controleVacinas.Pais;
import model.entity.controleVacinas.Pessoa;
import model.repository.vemNoX1.Banco;

public class PaisRepository {
	
	public Pais salvar(Pais novoPais) {
		String query = "INSERT INTO pais (nome, sigla) VALUES (?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement psmt =  Banco.getPreparedStatementWithPk(conn, query);
		
		
try {
			
			psmt.setString(1, novoPais.getNome());
			psmt.setString(2, novoPais.getSigla());
			
			psmt.execute();
			ResultSet resultado = psmt.getGeneratedKeys();
			
			if (resultado.next()) {
				novoPais.setId(resultado.getInt(1));
				
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao salvar a nova Pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(psmt);
			Banco.closeConnection(conn);
		}
		
		
		return novoPais;
		
	}

	

	public Pais consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		Pais pais = null;
		ResultSet resultado = null;
		String query = " SELECT * FROM pais WHERE id = " + id;
		
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				pais = new Pais();
				pais.setId(resultado.getInt("ID_PAIS_ORIGEM"));
				pais.setNome(resultado.getString("NOME"));
				pais.setSigla(resultado.getString("SIGLA"));
				
			}
		} catch (SQLException erro){
			System.out.println("Erro ao consultar pais com o id: " + id);
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pais;
	}

	
}
