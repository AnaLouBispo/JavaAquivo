package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.Produto;

public class GerenciamentoProdutos {

	private static final String fileName = "produto.txt";

	// Verificar a Existencia do nosso banco de dados e criar caso não exista
	public void verificarECriaProduto(String filename) {
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

	public void addProduto(Produto product) {
		// Writter = Escrever
		// Buffferwriter , FileWriter
		// Buffferwriter , proporicona uma eficiente escrita
		// FileWriter, escreve dentro do arquivo txt
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
			bw.write(product.toString());
			bw.newLine();// Nova linha no arquivo txt
			System.out.println("Usuario adicionado com success");
		} catch (IOException e) {
			System.out.println("erro ao escrever no arquivo" + e.getMessage());
		}
	}

	public List<Produto> lerProduto() {
		List<Produto> produtos = new ArrayList<Produto>();
		// Buffered, file, reader
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String linha; // linha => 1;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // dividir em três partes
				// Adicionar produtos à listam
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void deletarProduto(int id) {
		List<Produto> products = lerProduto();
		if (products.removeIf(product -> product.getId() == id)) {
			reescreverAquivo(products);
			System.out.println("Usuario deletado com sucesso ");
		} else {
			System.out.println("Usuario nao encontrado");
		}

	}

	public void editarProduto(int id, String Novonome, int novaQtd, double novoPreco) {
		List<Produto> products = lerProduto();
		boolean econtrado = false;
		for (Produto produto : products) {
			if (produto.getId() == id) {
				produto.setNome(Novonome);
				produto.setQuantidade(novaQtd);
				produto.setPreco(novoPreco);
				econtrado = true;
				break;
			}

		}

		if (econtrado) {
			reescreverAquivo(products);
			System.out.println("Usuario Atualizado com Sucesso");
		} else {
			System.out.println("Usuario nao econtrado");
		}
	}

	public void reescreverAquivo(List<Produto> products) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (Produto produto : products) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever arquivo" + e.getMessage());
		}
	}

	public void listarProdutos() {
		List<Produto> products = lerProduto();
		if (products.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Listar Usuarios");
			for (Produto produto : products) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome() + ", Preço: "
						+ produto.getPreco() + "QTD: " + produto.getQuantidade());
			}
		}
	}

	public void produtoEspecifico(int id) {
		boolean encontrado = false;
		List<Produto> products = lerProduto();
		for (Produto product : products) {
			if (product.getId() == id) {
				System.out.println("ID: " + product.getId() + ", Nome: " + "" + product.getNome() + ", QTD: "
						+ product.getQuantidade() + " Preço: " + product.getPreco());
				encontrado = true;
				break;
			}
		}

		if (encontrado) {
			System.out.println("Listando o Usario: ");
		} else {
			System.out.println("Usuario nao econtrado");
		}
	}

	public void SomarProd() {
		List<Produto> products = lerProduto();
		double soma = 0;
		for (Produto product : products) {
			soma += product.getPreco() * product.getQuantidade();
		}
		System.out.println("Total de produtos: " + soma);

	}

	public void CalcularQTDProd() {
		List<Produto> products = lerProduto();
		double soma = 0;
		for (Produto product : products) {
			soma += product.getQuantidade();
		}
		System.out.println("Total de produtos: " + soma);
	}

}
