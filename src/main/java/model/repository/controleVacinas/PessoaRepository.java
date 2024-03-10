package model.repository.controleVacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import model.entity.controleVacinas.pessoas.Pessoa;
import model.repository.vemNoX1.Banco;

public class PessoaRepository {
	
	public Pessoa salvar(Pessoa novaPessoa) {
		String query = "INSERT INTO pessoa (nome, data_nascimento, sexo, "
				+ "cpf, tipo_pessoa, avaliacao) VALUES (?,?,?,?,?,?)";
		Connection conn = Banco.getConnection();
		PreparedStatement psmt = Banco.getPreparedStatement(conn, query);
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

}
