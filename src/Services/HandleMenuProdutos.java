package Services;

import java.util.List;
import java.util.Scanner;

import Models.Produto;

import Utils.GerenciamentoProdutos;

public class HandleMenuProdutos {
	

	Scanner sc = new Scanner(System.in);
	GerenciamentoProdutos gs =  new GerenciamentoProdutos();
	
	public HandleMenuProdutos() {
		gs.verificarECriaProduto("produto.txt");
	}
		public void criar() {
			System.out.println("Digite o Nome do Produto: ");
			String nome =  sc.next();
			System.out.println("Digite a quantidade:");
			int qtd = sc.nextInt();
			
			System.out.println("Qual é valor do produto: ");
			double preco =  sc.nextDouble();
		
			long id = getNextId();
			
			Produto products = new Produto(id, nome, preco, qtd);
			gs.addProduto(products);
		
		}
		 
		public void editar() {
			System.out.println("Digite o ID do produto: ");
			int id = sc.nextInt();
			System.out.println("Digite o novo produto: ");
			String nome = sc.next();
			System.out.println("Digite o novo valor do produto: ");
			double preco = sc.nextDouble();
			System.out.println("Digite a quantidade do produto: ");
			int qtd =  sc.nextInt();
			gs.editarProduto(id, nome, qtd, preco);
			
		}
		 
		
		public void listar() {
		gs.listarProdutos();
			
		}
		
		public void deletar() {
			System.out.println("Qual id do usuario a ser deletado");
			int id =  sc.nextInt();
			gs.deletarProduto(id);
					
		}
		
		private long getNextId() {
			List<Produto> products = gs.lerProduto();
			long maxId = 0;
			for (Produto produto : products) {
				long id = produto.getId();
				// Logica para descobrir a ultimo id
				if (id > maxId) {
					maxId = id;
				}
			}
			// Soma 1 + o ultimo
			return maxId + 1;
		}
		
		public void ListarEspecifico() {
			System.out.println("Qual id do Usuario que voce deseja vizualizar");
			int id = sc.nextInt();
			gs.produtoEspecifico(id);
		}
		
		 
		public void Soma(){
			gs.SomarProd();
		}
		
		public void QTDProd() {
			gs.CalcularQTDProd();
		}
		
		
	}



