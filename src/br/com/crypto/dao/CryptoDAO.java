package br.com.crypto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.agenda.factory.FactoryConnection;
import br.com.crypto.model.Crypto;

public class CryptoDAO {
	// In the DAO we create all of the methods for the CRUD;

	/*
	 * public void createDatabase() { String sql =
	 * "CREATE TABLE crypto (id SERIAL NOT NULL PRIMARY KEY," +
	 * "name VARCHAR(50), symbol VARCHAR(10), amount REAL, priceBought REAL," +
	 * "dateBought DATE)";
	 * 
	 * Connection con = null; PreparedStatement pstm = null;
	 * 
	 * try { con = FactoryConnection.createConnectionToPostgre(); pstm =
	 * con.prepareStatement(sql);
	 * 
	 * pstm.execute(); System.out.println("Banco criado com sucesso."); } catch
	 * (Exception e) { e.printStackTrace(); } finally { try { if (pstm != null) {
	 * pstm.close(); } if (con != null) { con.close(); } } catch (Exception e) {
	 * e.printStackTrace(); } } }
	 */

	public void addCrypto(Crypto crypto) {
		String sql = "INSERT INTO crypto (name, symbol, amount, priceBought, dateBought) VALUES (?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = FactoryConnection.createConnectionToPostgre();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, crypto.getName());
			pstm.setString(2, crypto.getSymbol());
			pstm.setDouble(3, crypto.getAmount());
			pstm.setDouble(4, crypto.getPriceBought());
			pstm.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));

			pstm.execute();
			System.out.println("Moeda cadastrada com sucesso!");

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
}
