package model.repository.controleVacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import model.entity.controleVacinas.enumerador.Sexo;
import model.entity.controleVacinas.enumerador.TipoPessoa;
import model.entity.controleVacinas.pessoas.Pessoa;
import model.repository.vemNoX1.Banco;

public class PessoaRepository {
	
	public Pessoa salvar(Pessoa novaPessoa) {
		String query = "INSERT INTO pessoa (nome, data_nascimento, sexo, "
				+ "cpf, tipo_pessoa, avaliacao) VALUES (?,?,?,?,?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement psmt = Banco.getPreparedStatementWithPk(conn, query);
		


		try {
			
			psmt.setString(1, novaPessoa.getNome());
			psmt.setDate(2, Date.valueOf(novaPessoa.getDataNascimento()));
			psmt.setString(3, novaPessoa.getSexo().toString());
			psmt.setString(4, novaPessoa.getCpf());
			psmt.setString(5, novaPessoa.getTipoPessoa().toString());
			psmt.setInt(6, novaPessoa.getAvaliacao());
			
			psmt.execute();
			ResultSet resultado = psmt.getGeneratedKeys();
			
			if (resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
				
			}
			
		} catch (SQLException erro) {
			System.out.println("Erro ao salvar a nova Pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(psmt);
			Banco.closeConnection(conn);
		}
		
		return novaPessoa;
		
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM pessoa WHERE id = " + id;
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
	
	public ArrayList<Pessoa> consultarTodas(){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = "SELECT * FROM pessoa";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(Integer.parseInt(resultado.getString("ID")));
				pessoa.setNome(resultado.getString("NOME"));
				pessoa.setDataNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate());
				pessoa.setSexo(Sexo.valueOf(resultado.getString("SEXO")));
				pessoa.setTipoPessoa(TipoPessoa.valueOf(resultado.getString("TIPO_PESSOA")));
				pessoa.setAvaliacao(resultado.getInt("AVALIACAO"));
				pessoas.add(pessoa);
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todas as jogadors");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}
}	
	
	
	

