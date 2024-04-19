package Sistemas;

import java.util.Scanner;

import Services.HandleMenu;

public class Sistema {

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int op = 0;

		do {
			System.out.println(
					"1-Criar Usuario \n2-Editar Usuario \n3-Deletar \n4-listar \n9-Sair \n5-Listar Unico \n6-Logar \n7-Trocar Senha \n9-Sair ");
			op = sc.nextInt();

			System.out.println("-----------------------------");
			switch (op) {
			case 1: {
				hm.criar();

				break;
			}
			case 2: {
				hm.editar();
				break;
			}
			case 3: {
				hm.deletar();
				break;
			}
			case 4: {
				hm.listar();
				break;
			}
			case 5: {
				hm.ListarEspecifico();
				break;
			}
			case 6: {
				hm.logarUsuario();
				break;
			}
			case 7: {
				hm.TrocarSenha();
				break;
			}

			case 9: {
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
