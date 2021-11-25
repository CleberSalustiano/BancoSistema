package BancoSistema;

public class CodigoSegurancaIncorretoException extends Exception {

	private String codigo;

	public CodigoSegurancaIncorretoException(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public String getMessage() {
		return "O codigo '" + codigo + "' esta incorreto. \nVoce nao tem permissao para abastecer";
	}
	
	
	
}
