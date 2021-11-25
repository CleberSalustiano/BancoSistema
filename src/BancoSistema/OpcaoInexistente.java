package BancoSistema;

public class OpcaoInexistente extends Exception{

	@Override
	public String getMessage() {
		return "Opcao Inexistente!\n";
	}

}
