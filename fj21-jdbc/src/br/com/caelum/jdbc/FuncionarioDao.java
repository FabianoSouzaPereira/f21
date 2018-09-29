package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;

	public FuncionarioDao() {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "Insert into funcionario (nome,usuario,senha) values(?,?,?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Funcionario> getLista() {

		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("Select * from Funcionario;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				funcionarios.add(funcionario);
			}
			
			rs.close();
			stmt.close();
			return funcionarios;
			
		} catch (SQLException e) {
			throw new	RuntimeException(e);
		}

	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
