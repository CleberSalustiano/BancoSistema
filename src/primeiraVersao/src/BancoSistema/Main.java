package BancoSistema;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		Caixa caixa = new Caixa();
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo ao Caixa");
		menu();
		int opcao = scan.nextInt();
		while (opcao != 3) {
			switch(opcao) {
			case 1:
				sacar(scan,caixa);
				break;
			case 2:
				abastecerPermissao(scan,caixa);
				break;
			default:
				opcaoInexistente();
			}
			menu();
			opcao = scan.nextInt();
		}
	}
	private static void abastecerPermissao(Scanner scan, Caixa caixa) {
		System.out.println("Para poder abastecer, digite o codigo de Seguranca");
		String codigo = scan.next();
		if(caixa.confereCodigo(codigo)) {
			menuNotas();
			int opcao = scan.nextInt();
			if (opcao == 1 ||opcao == 2|| opcao == 3||opcao == 4 ) {
				abastecerEnviar(opcao, caixa, scan);
			}else {
				opcaoInexistente();
			}
		}else {
			try {
				throw new CodigoSegurancaIncorreto(codigo);
			} catch (CodigoSegurancaIncorreto e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
	}
	private static void abastecerEnviar(int opcao, Caixa caixa, Scanner scan) {
		System.out.println("Digite a quantidade: ");
		int quantidade = scan.nextInt();
		caixa.abastecer(opcao, quantidade);
		System.out.println("Valor total no caixa: R$"+caixa.atualizaTotal()+",00.\n");
	}
	private static void opcaoInexistente() {
		try {
			throw new OpcaoInexistente();
		} catch (OpcaoInexistente e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("Ocorreu algum erro! Digite novamente");
		}
	}
	private static void sacar (Scanner scan, Caixa caixa) {
		System.out.println("Digite a quantidade desejada para saque: ");
		int valorSaque = scan.nextInt();
		caixa.liberanotas(valorSaque);
	}
	private static void menuNotas() {
		System.out.println("Escolha qual nota deseja abastecer: ");
		System.out.println("1 - Notas de 10.");
		System.out.println("2 - Notas de 20.");
		System.out.println("3 - Notas de 50.");
		System.out.println("4 - Notas de 100.");
	}
	private static void menu () {
		System.out.println("Escolha uma opção abaixo: ");
		System.out.println("1 - Sacar");
		System.out.println("2 - Abastecer");
		System.out.println("3 - Sair");
	}
}
