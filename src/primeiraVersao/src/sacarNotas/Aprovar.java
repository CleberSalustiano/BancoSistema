package sacarNotas;

import registroNotas.Registro;

public class Aprovar {
	private int liberanotas10;
	private int liberanotas20;
	private int liberanotas50;
	private int liberanotas100;
	
	
	public void aprov(int quant, Registro caixa) {
		caixa.total();
		int aux = quant;
		int nota10, nota20, nota50, nota100;
		int bnota10 = caixa.nota10;
		int bnota20 = caixa.nota20;
		int bnota50 = caixa.nota50;
		int bnota100 = caixa.nota100;
		liberanotas10 = 0;
		liberanotas20 = 0;
		liberanotas50 = 0;
		liberanotas100 = 0;
		if (quant > caixa.total) {
			System.out.printf("A quantia de R$%d,00 é superior a máxima (R$%d,00).\nTente uma quantia menor!", quant, caixa.total);
		}else{
			while (aux != 0) {
				if (aux < 100) {
					if (aux < 50) {
						if(aux < 20) {
							if(aux < 10) {
								System.out.println("Nao foi possivel sacar esse valor, nao ha combinaçao de celudas equivalente.");
								caixa.nota10 = bnota10;
								caixa.nota20 = bnota20;
								caixa.nota50 = bnota50;
								caixa.nota100 = bnota100;
								break;
							}else {
								aux -= 10;
								if(caixa.nota10 >= 1) {
									caixa.nota10 --;
									liberanotas10 += 1;}
								else {
									System.out.println("Nao foi possivel sacar esse valor, nao ha combinaçao de celudas equivalente.");
									caixa.nota10 = bnota10;
									caixa.nota20 = bnota20;
									caixa.nota50 = bnota50;
									caixa.nota100 = bnota100;
									break;
								}
							}
						}else {
							aux -= 20;
							if (caixa.nota20 >= 1) { 
								caixa.nota20 --;
								liberanotas20 += 1;}
							else if (caixa.nota10 >= 2) {
								caixa.nota10 -= 2;
								liberanotas10 += 2;}
							else {
								System.out.println("Nao foi possivel sacar esse valor, nao ha combinaçao de celudas equivalente.");
								caixa.nota10 = bnota10;
								caixa.nota20 = bnota20;
								caixa.nota50 = bnota50;
								caixa.nota100 = bnota100;
								break;
							}
						}
					}else {
						aux -= 50;
						if (caixa.nota50 >= 1) {
							caixa.nota50 --;
							liberanotas50 += 1;}
						else if(caixa.nota20 >= 2 && caixa.nota10 >= 1) {
							caixa.nota20 -= 2;
							caixa.nota10 -= 1;
							liberanotas10 += 1;
							liberanotas20 += 2;
						}else if (caixa.nota20 == 1 && caixa.nota10 >= 4) {
							caixa.nota20 -= 1;
							caixa.nota10 -= 4;
							liberanotas10 += 4;
							liberanotas20 += 1;
						}else if (caixa.nota10 >= 5) {
							caixa.nota10 -= 5;
							liberanotas10 += 5;
						}else{
							System.out.println("Nao foi possivel sacar esse valor, nao ha combinaçao de celudas equivalente.");
							caixa.nota10 = bnota10;
							caixa.nota20 = bnota20;
							caixa.nota50 = bnota50;
							caixa.nota100 = bnota100;
							break;
						}
					}
				}
				else {
					aux -= 100;
					if (caixa.nota100 >= 1) { 
						caixa.nota100--;
						liberanotas100 += 1;}
					else if (caixa.nota50 >= 2) {
						caixa.nota50 -= 2;
						liberanotas50 += 2;}
					else if (caixa.nota50 == 1 && caixa.nota20 >= 2 && caixa.nota10 >= 1) {
						caixa.nota50 --; caixa.nota20 -= 2; caixa.nota10 --; liberanotas50 ++; liberanotas20 += 2; liberanotas10 ++;
					}
					else if (caixa.nota50 == 1 && caixa.nota20 == 1 && caixa.nota10 >= 3) {
						caixa.nota50 --;
						caixa.nota20 --;
						caixa.nota10 -= 3;
						liberanotas50 ++;
						liberanotas20 ++;
						liberanotas10 += 3;
					}
					else if (caixa.nota20 >= 4 && caixa.nota10 >= 2 ) {
						caixa.nota20 -= 4;
						caixa.nota10 -= 2;
						liberanotas20 += 4;
						liberanotas10 += 2;
					}else if (caixa.nota20 >= 3 && caixa.nota10 >= 4 ) {
						caixa.nota20 -= 3;
						caixa.nota10 -= 4;
						liberanotas20 += 3;
						liberanotas10 += 4;
					}
					else if (caixa.nota20 >= 2 && caixa.nota10 >= 6 ) {
						caixa.nota20 -= 2;
						caixa.nota10 -= 6;
						liberanotas20 += 2;
						liberanotas10 += 6;	
					}else if (caixa.nota20 == 1 && caixa.nota10 >= 8 ) {
						caixa.nota20 -= 1;
						caixa.nota10 -= 8;
						liberanotas20 += 1;
						liberanotas10 += 8;
					}else if (caixa.nota20 >= 5) {
						caixa.nota20 -= 5;
						liberanotas20 += 5;}
					else if (caixa.nota10 >= 10) {
						caixa.nota10 -= 10;
						liberanotas10 += 10;}

				}
				if (aux == 0) {
					caixa.total();
					System.out.printf("Saque de R$%d,00 feito\n", quant, caixa.total);
					if (liberanotas10 > 0)
						System.out.printf("%d notas de R$10,00\n", liberanotas10);
					if (liberanotas20 > 0)
						System.out.printf("%d notas de R$20,00\n", liberanotas20);
					System.out.printf("%d, %d, %d, %d\n",liberanotas10,liberanotas20,liberanotas50,liberanotas100);
					if (liberanotas50 > 0)
						System.out.printf("%d notas de R$50,00\n", liberanotas50);
					if (liberanotas100 > 0)
						System.out.printf("%d notas de R$100,00\n", liberanotas100);
				}
			}
		
		}
	}

}
	
