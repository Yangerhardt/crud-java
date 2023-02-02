package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("João Ricardo");
		contato.setIdade(45);
		contato.setDataCadastro(new Date());
		
		// contatoDao.add(contato);
		
		// Atualizar o contato:
		
		Contato c1 = new Contato();
		c1.setNome("João Ricardo da Silva");
		c1.setIdade(70);
		c1.setDataCadastro(new Date());
		c1.setId(4);
		
		contatoDao.update(c1);
		
		
		
		// Vizualização de todos os registros do banco de dados
		
		for (Contato c : contatoDao.getContatos()) {
			System.out.println("ID: " + c.getId());
			System.out.println("Contato: " + c.getNome());
			System.out.println("Idade: " + c.getIdade());
			System.out.println("Data de Cadastro: " + c.getDataCadastro());
			System.out.println();
		}
		
		// Deletar contato: 
		
		 contatoDao.deleteByID(2);
		
		
		
	}
}
