package BancoSistema;

public class CombinacaoNotasInexistenteException extends Exception {

	@Override
	public String getMessage() {
		return "Combinacao de Notas Inexistente!\n";
	}

	
	
}
