package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "admin";
	private Connection c = null;

	public Connection getConnection() {
		if (c == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c = DriverManager.getConnection(url, user, password);
				System.out.println("Conectou com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao conectar: " + e);
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao registrar: " + e);
			}
		}
		return c;
	}

	public void closeConnection() {
		if (c != null) {
			try {
				c.close();
				System.out.println("Fechou a conexao com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao: " + e);
			}
		}
	}

}
