package BancoSistema;

public class ValorMaiorQueTotalException extends Exception {
	
	private int valorTotal;
	
	
	
	public ValorMaiorQueTotalException(int valorTotal) {
		super();
		this.valorTotal = valorTotal;
	}


	@Override
	public String getMessage() {
		return "Valor maior do que o existente nesse caixa: R$" + valorTotal + ",00.\n";
	}
	
}
