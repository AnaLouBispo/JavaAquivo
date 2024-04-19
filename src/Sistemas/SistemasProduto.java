package Sistemas;

import java.util.Scanner;

import Services.HandleMenuProdutos;

public class SistemasProduto {
	

		public static void main(String[] arg) {
			Scanner sc = new Scanner(System.in);
			HandleMenuProdutos hm = new HandleMenuProdutos();
			int op = 0 ;
			
			

			do {
				System.out.println("1-Criar Produto \n2-Editar Produto \n3-Deletar \n4-listar \n5-Listar Unico \n6-Somar \n7-Calcular QTD \n9-Sair ");
				op = sc.nextInt();
				
				System.out.println("-----------------------------");
				switch (op) {
				case 1: {
					hm.criar();
					
					break;
				}
				case 2:{
					hm.editar();
					break;
				}
				case 3:{
					hm.deletar();
					break;
				}
				case 4:{
					hm.listar();
					break;
				}
				case 5:{
					hm.ListarEspecifico();
					break;
				}
				case 6:{
					hm.Soma();
					break;
				}
				case 7: {
					hm.QTDProd();
					break;
				}
				
				case 9:{
					System.exit(0);
				}
				
				
				default:
					System.out.println("Opção Invalida");
					break;
				}	
				
			} while (op != 9);
			sc.close();
			
			
			
			
		}
	}

	
	
	
	
	
	


