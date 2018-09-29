/**
 * 
 */
package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

/**
 * @author fabiano
 *
 */
public class TesteDeleteFuncionario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection =  new ConnectionFactory().getConnection();
		System.out.println("Conexão	aberta!");
		
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setId((long) 3);
			FuncionarioDao dao = new FuncionarioDao();
			dao.apaga(funcionario);
			System.out.println("Apagado!");
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
