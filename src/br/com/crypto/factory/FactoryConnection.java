package br.com.crypto.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FactoryConnection {
	
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "12345";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/crypto";
	
	public static Connection createConnectionToPostgre() throws Exception {
		
		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conexao;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToPostgre();
		
		if (con!=null) {
			System.out.println("Conexão estabelecida com sucesso");
			con.close();
		}
	}
}
