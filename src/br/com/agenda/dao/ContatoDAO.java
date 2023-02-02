package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.agenda.factory.FactoryConnection;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	// DAO = Data Access Object

	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES(?, ?, ?)";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			// Criar uma conexao com o banco
			con = FactoryConnection.createConnectionToPostgre();

			// Criamos uma preparedStatement para executar uma query do SQL;
			pstm = con.prepareStatement(sql);

			// Adicionar os valores esperados pela QUERY (Que estão como "?")
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executar a QUERY
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fechar as conexões caso estejam abertas
			try {
					if (pstm != null) {
						pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
