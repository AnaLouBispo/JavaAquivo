package Models;

import java.util.List;

import Utils.GerenciadorDeUsuario;

public class Usuario {

	GerenciadorDeUsuario gs = new GerenciadorDeUsuario();
	private int ID;
	private String nome;
	private String senha;

	public Usuario(int iD, String nome, String senha) {
		super();
		ID = iD;
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return ID + ";" + nome + ";" + senha;
	}


}
