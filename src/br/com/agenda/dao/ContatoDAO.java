package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.FactoryConnection;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	// DAO = Data Access Object

	public void add(Contato contato) {
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

	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = FactoryConnection.createConnectionToPostgre();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());

			pstm.execute();
			System.out.println("O contato foi atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	public void deleteByID(int id) {
		String sql = "DELETE FROM contatos WHERE id = ?";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = FactoryConnection.createConnectionToPostgre();
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
			System.out.println("Usuário deletado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	public List<Contato> getContatos() {
		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection con = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco:
		ResultSet rset = null;

		try {
			con = FactoryConnection.createConnectionToPostgre();

			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				// Recuperar o id
				contato.setId(rset.getInt("id"));
				// Recuperar o nome
				contato.setNome(rset.getString("nome"));
				// Recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				// Recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("dataCadastro"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return contatos;
	}
}
