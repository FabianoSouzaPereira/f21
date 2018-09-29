package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDelete {

	public static void main(String[] args) {
		Connection	connection	=	new	ConnectionFactory().getConnection();
		System.out.println("Conexão	aberta!");
		
		try {
			Contato contato = new Contato();
			contato.setId((long) 2);
			ContatoDao dao = new ContatoDao();
			dao.remove(contato);
			System.out.println("Apagado!");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
