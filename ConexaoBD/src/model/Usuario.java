package model;

/**
 * 
 * @author neli
 *  JavaBean para representar a tabela Usuario
 *  JavaBean é uma classe com um construtor sem argumentos, com os atributos privados e com getteres e setters para todos os atributos
 *  
 */

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public void mostraUsuario() {
		System.out.println("Dados do Usuario");
		System.out.println("Id....: "+this.getIdUsuario());
		System.out.println("Nome..: "+this.getNomeUsuario());
		System.out.println("E-mail: "+this.getEmailUsuario());
		System.out.println("Senha.: "+this.getSenhaUsuario());	
	}
	
}
