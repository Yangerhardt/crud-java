package br.com.crypto.main;

import java.util.Date;

import br.com.crypto.dao.CryptoDAO;
import br.com.crypto.model.Crypto;

public class Main {
	public static void main(String[] args) {
		CryptoDAO cryptoDao = new CryptoDAO();

		// Precisa ser executado somente uma vez para a criação do banco;
		// cryptoDao.createDatabase();
		
		Crypto crypto = new Crypto("Bitcoin", "BTC", 0.1, 2400, new Date());
			
		 cryptoDao.addCrypto(crypto);
	}
}
