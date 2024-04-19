package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Usuario;

public class GerenciadorDeUsuario {

	private static final String fileName = "usuario.txt";
	Scanner sc = new Scanner (System.in);
	// Verificar a Existencia do nosso banco de dados e criar caso não exista
	public void verificarECria(String filename) {
		File arquivo = new File(filename);
		if (arquivo.exists()) {
			System.out.println("Banco Funcionando");
		} else {
			// tente criar o arquivo
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.out.println("Erro ao criar ao arquivo" + e.getMessage());
			}
		}
	}

	public void AddUsuario(Usuario usuario) {
		// Writter = Escrever
		// Buffferwriter , FileWriter
		// Buffferwriter , proporicona uma eficiente escrita
		// FileWriter, escreve dentro do arquivo txt
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
			bw.write(usuario.toString());
			bw.newLine();// Nova linha no arquivo txt
			System.out.println("Usuario adicionado com success");
		} catch (IOException e) {
			System.out.println("erro ao escrever no arquivo" + e.getMessage());
		}
	}

	public List<Usuario> lerUsuario() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Buffed, file, reader
		String linha;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuario();
		if (usuarios.removeIf(usuario -> usuario.getID() == id)) {
			reescreverAquivo(usuarios);
			System.out.println("Usuario deletado com sucesso ");
		} else {
			System.out.println("Usuario nao encontrado");
		}

	}
	
	public void  editarUsuario(int id, String Novonome , String novSenha) {
		List<Usuario> usuarios =  lerUsuario();
		boolean econtrado = false;
		for(Usuario usuario : usuarios) {
			if(usuario.getID() == id) {
				usuario.setNome(Novonome);
				usuario.setSenha(novSenha);
				econtrado = true;
				break;
			}
			
		}
		
		if(econtrado) {
			reescreverAquivo(usuarios);
			System.out.println("Usuario Atualizado com Sucesso");
		}else {
			System.out.println("Usuario nao econtrado");
		}
	}

	public void reescreverAquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever arquivo" + e.getMessage());
		}
	}

	public void lerUsuarios() {
		List<Usuario> usuarios = lerUsuario();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Listar Usuarios");
			for (Usuario usuario : usuarios) {
				System.out.println(
			"ID: " + usuario.getID() + ", Nome: " + "" + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}
		}
	}
	
	
	public void usuarioEspecifico(int id) {
		boolean encontrado = false;
		List<Usuario> usuarios = lerUsuario();
			for (Usuario usuario : usuarios) {
				if(usuario.getID() == id) {
					System.out.println(
					"ID: " + usuario.getID() + ", Nome: " + "" + usuario.getNome() + ", Senha: " + 
					usuario.getSenha());
					encontrado = true;
					break;
				}
				
				if(encontrado) {
					System.out.println("Listando o Usario: ");
				}else {
					System.out.println("Usuario nao econtrado");
				}
				
		}
	}
	
	public void logarUser(String senha, String nome) {
		List<Usuario> usuarios = lerUsuario();
		boolean encontrado = false;
		 for(Usuario usuario : usuarios) {
			 if(usuario.getSenha().equals(senha) && usuario.getNome().equals(nome)) {
				 encontrado = true;
			 }
			 
		 }
			if(encontrado) {
				System.out.println("Logado com Sucesso");
			}else {
				System.out.println("Algum dado esta incorreto");
			}
	}

	public void switchPassWord(int id, String senha ) {
		List<Usuario> usuarios = lerUsuario();
		boolean encontrado = false;
		for(Usuario usuario : usuarios) {
			if(usuario.getID() == id) {
				if(usuario.getSenha().equals(senha)) {
					System.out.println("Digite a nova senha: ");
					String novaSenha = sc.next();
					usuario.setSenha(novaSenha);
					encontrado = true;
				}
			}
		}
		if(encontrado) {
			reescreverAquivo(usuarios);
			
			System.out.println("Senha atualizada");
		}else {
			System.out.println("Dados incorretos");
		}
	}
	
	public void listarid() {
		List<Usuario> usuarios = lerUsuario();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Listar Usuarios");
			for (Usuario usuario : usuarios) {
				System.out.println(
			"ID: " + usuario.getID() + ", Nome: " + "" + usuario.getNome());
			}
		}
	}
	
}
	
	
	
	
	

	
	
	
	

