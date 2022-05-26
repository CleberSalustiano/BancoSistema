package BancoSistema;

public class CodigoSegurancaIncorreto extends Exception {

	private String codigo;

	public CodigoSegurancaIncorreto(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public String getMessage() {
		return "O codigo '" + codigo + "' esta incorreto. \nVoce nao tem permissao para abastecer";
	}
	
	
	
}
