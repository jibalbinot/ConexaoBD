/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neli Classe responsável por fazer o CRUD de um Usuario no BD C create
 *         (inserir um registro no BD) R read (ler um registro do BD) U update
 *         (atualizar um registro no BD) D delete (apagar um registro do BD)
 * 
 *         CREATE TABLE USUARIO( IDUSUARIO NUMBER NOT NULL, NOMEUSUARIO
 *         VARCHAR(50) NOT NULL, EMAILUSUARIO VARCHAR(50) NOT NULL, SENHAUSUARIO
 *         VARCHAR(50) NOT NULL, CONSTRAINT PK PRIMARY KEY (EMAILUSUARIO));
 */
public class UsuarioDAO {
	private Connection c = null;

	public UsuarioDAO() {
		this.c = new ConnectionFactory().getConnection();
	}

	/**
	 * C - Create - Método responsável por inserir um objeto Usuario no Banco de
	 * dados
	 */
	public void insere(Usuario u) {

		try {

			// Se não tiver uma conexão ela será criada
			if (this.c == null) {
				this.c = new ConnectionFactory().getConnection();
			}

			// clausula SQL
			String sql = "INSERT INTO Usuario" + " (idUsuario,nomeUsuario,emailUsuario,senhaUsuario)"
					+ " values (?,?,?,?)";

			// Carregamento dos dados do Usuário da memória para o PS
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, u.getIdUsuario());
			ps.setString(2, u.getNomeUsuario());
			ps.setString(3, u.getEmailUsuario());
			ps.setString(4, u.getSenhaUsuario());

			// Executa o comando e insere os dados no BD
			ps.execute();

			// Fecha a conexão a cada operação
			// this.c.close();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir Usuario: " + e);
		}
	}

	/**
	 * R - Read - Método responsável por consultar um objeto Usuario no Banco de
	 * dados
	 */
	public Usuario consulta(Usuario u) {
		try {

			// Se não tiver uma conexão ela será criada
			if (this.c == null) {
				this.c = new ConnectionFactory().getConnection();
			}

			// clausula SQL
			// select * from usuario where emailusuario='jibalbinot@gmail.com' and
			// senhausuario='admin';
			String sql = "SELECT * FROM Usuario WHERE emailUsuario=? AND senhaUsuario=?";

			// Carregamento do sql para o PS
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, u.getEmailUsuario());
			ps.setString(2, u.getSenhaUsuario());

			// Executa o comando que consulta todos os registros de usuarios do BD e
			// armazena no rs
			ResultSet rs = ps.executeQuery();

			Usuario aux = null;
			// percorre o RS para ver se retornou um registro da consulta
			while (rs.next()) {
				aux = new Usuario();
				aux.setIdUsuario(rs.getInt("IdUsuario"));
				aux.setNomeUsuario(rs.getString("NomeUsuario"));
				aux.setEmailUsuario(rs.getString("EmailUsuario"));
				aux.setSenhaUsuario(rs.getString("SenhaUsuario"));
			}

			// Fecha a conexão a cada operação
			// this.c.close();

			return aux;

		} catch (SQLException e) {
			System.out.println("Erro ao consultar Usuario: " + e);
		}
		return null;
	}

	/**
	 * R - Read - Método responsável por consultar todos os registros de Usuario no
	 * Banco de dados
	 */
	public List<Usuario> consultaTodos() {
		try {

			// Se não tiver uma conexão ela será criada
			if (this.c == null) {
				this.c = new ConnectionFactory().getConnection();
			}

			// clausula SQL
			String sql = "SELECT * FROM Usuario";

			// Carregamento do sql para o PS
			PreparedStatement ps = c.prepareStatement(sql);

			// Executa o comando que consulta todos os registros de usuarios do BD e
			// armazena no rs
			ResultSet rs = ps.executeQuery();

			ArrayList<Usuario> lista = new ArrayList<Usuario>();

			// percorre cada linha que retornou da consulta do BD e cria um
			// usuario em memoria e adiciona na lista
			while (rs.next()) {
				Usuario u = new Usuario();// cria um Bean em memoria
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setNomeUsuario(rs.getString("NomeUsuario"));
				u.setEmailUsuario(rs.getString("EmailUsuario"));
				u.setSenhaUsuario(rs.getString("SenhaUsuario"));
				lista.add(u);// adiciona esse objeto na lista
			}

			// Fecha a conexão a cada operação
			//this.c.close();

			return lista;

		} catch (SQLException e) {
			System.out.println("Erro ao consultar Usuarios: " + e);
		}
		return null;
	}

	/**
	 * U - Update - Método responsável por atualizar um objeto Usuario no Banco de
	 * dados
	 */
	public void atualiza(Usuario u) {
	}

	/**
	 * D - Delete - Método responsável por apagar um objeto Usuario no Banco de
	 * dados
	 */
	public void apaga(Usuario u) {
	}

	public void fechaConexao() {
		if (this.c != null) {
			// Fecha a conexão a cada operação
			try {
				this.c.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao: " + e);
			}
		}
	}
}
