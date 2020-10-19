/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author neli Classe responsável por fazer o CRUD de um Usuario no BD C create
 *         (inserir um registro no BD) R read (ler um registro do BD) U update
 *         (atualizar um registro no BD) D delete (apagar um registro do BD)
 */
public class UsuarioDAO {
	private Connection c = null;

	public UsuarioDAO() {
		this.c = ConnectionFactory.getConnection();
	}

	/**
	 * C - Create - Método responsável por inserir um objeto Usuario no Banco de
	 * dados
	 */
	public void insere(Usuario u) {
		// clausula SQL
		String sql = "INSERT INTO Usuario" + " (idUsuario,nomeUsuario,emailUsuario,senhaUsuario)" + " values (?,?,?,?)";

		try {

			// Carregamento dos dados do Usuário da memória para o PS
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, u.getIdUsuario());
			ps.setString(2, u.getNomeUsuario());
			ps.setString(3, u.getEmailUsuario());
			ps.setString(4, u.getSenhaUsuario());

			// Executa o comando e insere os dados no BD
			ps.execute();

			// c.close();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir Usuario: " + e);
		}
	}

	/**
	 * R - Read - Método responsável por consultar um objeto Usuario no Banco de
	 * dados
	 */
	public void consulta(Usuario u) {
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
}
