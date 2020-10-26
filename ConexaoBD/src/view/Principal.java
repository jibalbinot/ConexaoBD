package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Usuario;
import model.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		//Controller
		
		//Responsável pelo CRUD de Usuarios
		//cria uma conexao no construtor
		UsuarioDAO ud = new UsuarioDAO();
		
		//Bean
		Usuario u = null;
				
		Scanner s = new Scanner(System.in);
		String resposta;
		
		System.out.println("Bem-vindo(a)");
		System.out.print("Já é usuário?[1-sim | 2-não]: ");
		resposta = s.nextLine();
		
		if(resposta.equals("1")) {
			//solicitar email e senha para logar
			u = telaLogin();
			
			//consulta se aquele usuario e senha está no banco
			u = ud.consulta(u);
			
			//se for diferente de null quer dizer que achou
			if(u!=null) {
				System.out.println("Logado com sucesso");
				System.out.println("Bem-vindo "+u.getNomeUsuario());
				//Depois de logado mostrara todos os dados na tela
				
				//Consulta todos os usuarios cadastrados no BD
				List<Usuario> lista = ud.consultaTodos();
				
				//View - posteriormente colocar um HTML
				//mostra na tela o resultado
				for(int i=0;i<lista.size();i++) {
					lista.get(i).mostraUsuario();
				}
				
			} else {
				System.out.println("Usuario ou senha invalidos");
			}
		} else {
			// ler os dados do usuário de uma tela/interface/console
			u = telaCadastro();

			// Gravar esses dados no banco de dados
			ud.insere(u);
		}
		
		
		//fecha a conexao ao final para liberar o recurso.
		ud.fechaConexao();
	
		
	}

	private static Usuario telaLogin() {
		Scanner s = new Scanner(System.in);

		// Cria um Bean (Usuario) na memoria
		Usuario u = new Usuario();

		// View
		System.out.println("Informe os dados do Usuario");
		System.out.print("E-mail: ");
		u.setEmailUsuario(s.nextLine());
		System.out.print("Senha.: ");
		u.setSenhaUsuario(s.nextLine());
	
		return u;
	}

	public static Usuario telaCadastro() {

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
