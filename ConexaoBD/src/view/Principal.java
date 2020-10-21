package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Usuario;
import model.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		//Controller
		
		//Responsável pelo CRUD
		UsuarioDAO ud = new UsuarioDAO();
		
		//Consulta todos os usuarios cadastrados no BD
		List<Usuario> lista = ud.consultaTodos();
		
		//mostra na tela o resultado
		for(int i=0;i<lista.size();i++) {
			lista.get(i).mostraUsuario();
		}
		
		// ler os dados do usuário de uma tela/interface/console
		//Usuario u = tela();

		// Gravar esses dados no banco de dados
		//ud.insere(u);
	}

	public static Usuario tela() {

		Scanner s = new Scanner(System.in);

		// Cria um Bean (Usuario) na memoria
		Usuario u = new Usuario();

		// View
		System.out.println("Informe os dados do Usuario");
		System.out.print("Nome..: ");
		u.setNomeUsuario(s.nextLine());
		System.out.print("E-mail: ");
		u.setEmailUsuario(s.nextLine());
		System.out.print("Senha.: ");
		u.setSenhaUsuario(s.nextLine());
		u.mostraUsuario();

		return u;
	}

}
