package sacarNotas;

import java.util.Scanner;

import registroNotas.Registro;

public class mainSacar {

	public static void main(String[] args) {
		Registro caixa = new Registro();
		Aprovar aprovar = new Aprovar();
		Scanner scanner = new Scanner(System.in);
		caixa.total();
		
		System.out.println("Selecione uma opcao: \n1-Sacar \n2-Sair");
		int x = scanner.nextInt();
		while (x != 2) {
			if (x == 1) {
				System.out.println("Digite a quantia desejada para sacar:");
				aprovar.aprov(scanner.nextInt(), caixa);
			}else
				System.out.println("ERRO! Opcao escolhida inexistente! Tente novamente.");
			System.out.println("\nSelecione uma opção: \n1-Sacar \n2-Sair");
			x = scanner.nextInt();
			
		}
		
	}

}
