package registroNotas;

import java.util.Scanner;

public class Registro {
	
	public int nota10 = 30;
	public int nota20 = 2;
	public int nota50 = 1;
	public int nota100 = 5;
	public int total = nota10*10 + nota20*20 + nota50*50 + nota100*100;;
	
	public void total(){
		total = nota10*10 + nota20*20 + nota50*50 + nota100*100;
	}
	

	public void abastecimento() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe qual nota sera abastecida:");
		System.out.println("1 - Notas 10 \n2 - Notas 20 \n3 - Notas 50 \n4 - Notas 100\n5 - Sair");
		int x = scanner.nextInt();
		while (x != 5) {
			if (x == 1) {
				nota10 += scanner.nextInt();
				System.out.printf("Abastecimento de notas de 10 concluido\n");}
			else if (x == 2) {
				nota20 += scanner.nextInt();
				System.out.printf("Abastecimento de notas de 20 concluido\n");}
			else if (x == 3) {
				nota50 += scanner.nextInt();
				System.out.printf("Abastecimento %d de notas de 50 concluido\n");}
			else if (x == 4) {
				nota100 += scanner.nextInt();
				System.out.printf("Abastecimento de notas de 100 concluido\n");}
			else 			
				System.out.println("ERRO! Opcao escolhida inexistente! Tente novamente.");
			System.out.println("Informe qual nota sera abastecida:");
			System.out.println("1 - Notas 10 \n2 - Notas 20 \n3 - Notas 50 \n4 - Notas 100\n5 - Sair");
			x = scanner.nextInt();
		}
		total();
		System.out.printf("Quantidade de notas : \n%d notas de 10, \n%d notas de 20, \n%d notas de 50, \n%d notas de 100.\nTotal em R$ %d\n", nota10, nota20, nota50, nota100, total);

	}
	
	public void validar(int aux) {
		if (aux >= 100) {
			aux = aux - 100;
			if (nota100 >= 1)
				nota100 = nota100 - 100;
			else if (nota50 >= 2) 
				nota50 -= 2;
			else if (nota20 >= 5) 
				nota20 -= 5;
			else
				nota10 -= 10;
			}else if (aux >= 50) {
			aux = aux - 50;
			if (nota50 >= 1) 
				nota50 --;
			else if(nota20 >= 2 && nota10 >= 1) {
				nota20 -= 2;
				nota10 -= 1;
			}else if (nota20 == 1 && nota10 >= 4) {
				nota20 -= 1;
				nota10 -= 4;
			}else
				nota10 -= 5;
			}else if (aux >= 20) {
				aux = aux - 20;
				if (nota20 >= 1) 
					nota20 --;
				else if (nota10 >= 2)
					nota10 -= 2;
			} else if(aux >= 10)
				aux = aux - 10;
	}
}
