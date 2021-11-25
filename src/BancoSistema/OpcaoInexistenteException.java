package BancoSistema;

public class OpcaoInexistenteException extends Exception{

	@Override
	public String getMessage() {
		return "Opcao Inexistente!\n";
	}

}
