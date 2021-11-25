package BancoSistema;

public class ValorMaiorQueSaldoException extends Exception {
	
	private int saldo;

	public ValorMaiorQueSaldoException(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String getMessage() {
		return "Valor maior do que o existente no seu saldo: R$" + saldo + ",00.\n";
	}

	
}
