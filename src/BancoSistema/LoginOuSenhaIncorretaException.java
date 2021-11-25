package BancoSistema;

public class LoginOuSenhaIncorretaException extends Exception {

	@Override
	public String getMessage() {
		return "Login ou Senha Incorretos";
	}

		

}
