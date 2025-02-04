package BancoSistema;

public class Caixa {

	private String codigoSeguranca = "1234";
	private int notas10 = 2;
	private int notas20 = 1;
	private int notas50 = 2;
	private int notas100 = 3;
	private int total;
	
	public void liberanotas(int valorSaque) {
		if (valorSaque > atualizaTotal()) {
			try {
				throw new ValorMaiorQueTotalException(atualizaTotal());
			}catch (ValorMaiorQueTotalException e) {
				System.out.println(e.getMessage());
			}
		}else {
			combinacaoNotas(valorSaque);
		}
	}
	public boolean confereCodigo(String codigo) {
		if(codigo.equals(codigoSeguranca))
			return true;
		else return false;
	}	
	private void combinacaoNotas (int valorSaque) {
		int liberanotas10 = 0; 
		int liberanotas20 = 0;
		int liberanotas50 = 0;
		int liberanotas100 = 0;
		int notas10 = this.notas10;
		int notas20 = this.notas20;
		int notas50 = this.notas50;
		int notas100 = this.notas100;
		while(valorSaque >= 0) {
			if (valorSaque >= 100 && notas100 > 0) {
				liberanotas100 ++;
				notas100 --;
				valorSaque -= 100;
			}else if (valorSaque >= 50 && notas50 > 0) {
				liberanotas50 ++;
				notas50 --;
				valorSaque -= 50;
			}else if (valorSaque >= 20 && notas20 > 0) {
				liberanotas20 ++;
				notas20 --;
				valorSaque -= 20;
			}else if (valorSaque >= 10 && notas10 > 0) {
				liberanotas10 ++;
				notas10 --;
				valorSaque -= 10;
			}else {
				try {
					throw new CombinacaoNotasInexistente();
				} catch (CombinacaoNotasInexistente e) {
					System.out.println(e.getMessage());
					break;
				}
			}	
		} if(valorSaque == 0) {
			this.notas10 = notas10;
			this.notas20 = notas20;
			this.notas50 = notas50;
			this.notas100 = notas100;
			imprimiSaque(liberanotas10,liberanotas20,liberanotas50,liberanotas100, valorSaque);
		}
	}	
	private void imprimiSaque(int ln10, int ln20, int ln50, int ln100, int saque) {
		System.out.println("Saque de R$" + saque + ",00 conclu�do!");
		System.out.println("Notas de 10: " + ln10);
		System.out.println("Notas de 20: " + ln20);
		System.out.println("Notas de 50: " + ln50);
		System.out.println("Notas de 100: " + ln100);
	}	
	public int atualizaTotal(){
		return notas10*10 + notas20*20 + notas50*50 + notas100*100;
	}
	public void abastecer(int opcao, int quantidade) {
		if (opcao == 1) {
			this.notas10 += quantidade;
			System.out.println(quantidade + " notas de 10 abastecidos");
		}else if (opcao == 2) {
			this.notas20 += quantidade;
			System.out.println(quantidade + " notas de 20 abastecidos");
		}else if (opcao == 3) {
			this.notas50 += quantidade;
			System.out.println(quantidade + " notas de 50 abastecidos");
		}else if (opcao == 4) {
			this.notas100 += quantidade;
			System.out.println(quantidade + " notas de 100 abastecidos");
		}				
	}	
}
