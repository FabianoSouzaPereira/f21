package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) throws SQLException {
		Connection	connection	=	new	ConnectionFactory().getConnection();
		System.out.println("Conex�o	aberta!");
		
		//	pronto	para	gravar
		Contato	contato	=	new	Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		try {
			//	grave	nessa	conex�o!!!
			ContatoDao	dao	= new ContatoDao();
			
			//	m�todo	elegante
			dao.adiciona(contato);
			
			System.out.println("Gravado!");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
