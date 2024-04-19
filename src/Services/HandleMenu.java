package Services;

import java.util.List;
import java.util.Scanner;

import Models.Usuario;
import Utils.GerenciadorDeUsuario;

public class HandleMenu {
	Scanner sc = new Scanner(System.in);
	GerenciadorDeUsuario gs =  new GerenciadorDeUsuario();
	
	//Construtor vazio
	public HandleMenu() {
		//to
		gs.verificarECria("usuario.txt");
	}
	
	
	
	public void criar() {
		System.out.println("Digite o Seu Nome: ");
		String nome =  sc.next();
		System.out.println("Digite sua senha:");
		String senha = sc.next();
		int id = getNextId();
		Usuario u = new Usuario(id,nome, senha);
		gs.AddUsuario(u);
	}
	 
	public void editar() {
		System.out.println("Digite o ID de usuario: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite a nova a senha: ");
		String senha = sc.next();
		gs.editarUsuario(id, nome, senha);
	}
	 
	
	public void listar() {
		gs.lerUsuarios();
		
	}
	
	public void deletar() {
		System.out.println("Qual id do usuario a ser deletado");
		int id =  sc.nextInt();
		gs.deletarUsuario(id);		
	}
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuario();
		int maxID = 0;
		for (Usuario usuario : usuarios) {
			int id = usuario.getID();
			// Logica para descobrir a ultimo id
			if (id > maxID) {
				maxID = id;
			}
		}
		// Soma 1 + o ultimo
		return maxID + 1;
	}
	
	public void ListarEspecifico() {
		System.out.println("Qual id do Usuario que voce deseja vizualizar");
		int id = sc.nextInt();
		gs.usuarioEspecifico(id);
	}
	public void logarUsuario() {
		System.out.println("Qual Nome do Usuario: ");
		String nome = sc.next();
		 System.out.println("Senha: ");
		 String senha =  sc.next();
		 
		 gs.logarUser(senha, nome);
	}
	
	

	 
	public void TrocarSenha() {
		gs.listarid();
		System.out.println("Digite seu id: ");
		int id = sc.nextInt();
		System.out.println("Qual é a senha antiga: ");
		String senha = sc.next();
		gs.switchPassWord(id,senha);
		
		
	}
	
	
	
}
