/**
 * 
 */
package br.com.caelum.jdbc.teste;

import java.sql.Connection;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;



/**
 * @author fabiano
 *
 */
public class TestaInsereFuncionario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão	aberta!");

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Ana Paula da Silva");
		funcionario.setUsuario("ana.silva");
		funcionario.setSenha("123456");

		try {
			FuncionarioDao dao = new FuncionarioDao();
			dao.adiciona(funcionario);
			System.out.println("Gravado!");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
