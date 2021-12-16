package BancoSistema;

public class Pessoa {

	private String nome;
	private String conta;
	private String senha;
	private boolean autorizacao = false;
	private int saldo;
	
	/*@Override
	public String toString() {
		return "Pessoa [conta=" + conta + ", senha=" + senha + "]";
	}*/
	
	public boolean isAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(boolean autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, String conta, String senha, boolean autorizacao, int saldo) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.senha = senha;
		this.autorizacao = autorizacao;
		this.saldo = saldo;
	}

	
	public Pessoa(String nome, String conta, String senha, int saldo) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public void liberaSaldo(int valorSaqueaux) {
		this.saldo -= valorSaqueaux;
	}
	
	
}
