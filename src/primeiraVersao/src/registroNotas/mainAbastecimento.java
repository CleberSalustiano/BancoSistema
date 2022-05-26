package registroNotas;

import java.util.Scanner;

import sacarNotas.Aprovar;

public class mainAbastecimento {

	public static void main(String[] args) {
		Registro registro = new Registro();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione uma opcao: \n1 - Abastecer caixa \n2 - Sair");
		int x = scanner.nextInt();
		while (x != 2) {
			if (x == 1)
				registro.abastecimento();
			else
				System.out.println("\"ERRO! Opcao escolhida inexistente! Tente novamente.\"");
			System.out.println("\nSelecione a opção: \n1 - Abastecer caixa \n2 - Sair");
			x = scanner.nextInt();
		}
	
	}
}
