package BancoSistema;
//comentario teste para poder testar o githubasdasd

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Caixa caixa = new Caixa();
		Scanner scan = new Scanner(System.in);
		ArrayList <Pessoa> pessoas = new ArrayList<>();
		Pessoa pessoa = new Pessoa();
		Dados dados = new Dados();
		caixa.lerNotas();
		dados.pessoasCadastradas(pessoas);
		pessoa = menuLogin(pessoas, scan);
		System.out.println("Bem vindo ao Caixa, " + pessoa.getNome());
		menu(pessoa);
		if(pessoa.isAutorizacao()) {
			escolhaOpcaoAutorizada(scan,pessoa,caixa);
		}else {
			escolhaOpcaoSemAutorizacao(scan,pessoa,caixa);
		}
		caixa.escreverNotas();

	}
	private static void escolhaOpcaoSemAutorizacao(Scanner scan, Pessoa pessoa, Caixa caixa) {
		int opcao = scan.nextInt();
		while (opcao != 2) {
			switch(opcao) {
			case 1:
				sacar(scan,caixa, pessoa);
				break;
			default:
				opcaoInexistente();
			}
			menu(pessoa);
			opcao = scan.nextInt();
		}				
	}
	private static void escolhaOpcaoAutorizada(Scanner scan, Pessoa pessoa, Caixa caixa) {
		int opcao = scan.nextInt();
		while (opcao != 3) {
			switch(opcao) {
			case 1:
				sacar(scan,caixa, pessoa);
				break;
			case 2:
				abastecerPermissao(scan,caixa);
				break;
			default:
				opcaoInexistente();
			}
			menu(pessoa);
			opcao = scan.nextInt();
		}		
	}
	private static Pessoa menuLogin(ArrayList<Pessoa> pessoa, Scanner scan) {
		Integer[] login = {0,null};
		int tentativa = 0;
		while (login[0] == 0 && tentativa < 3) {
			System.out.println("Digite seu email ou nome:");
			String nomeEmail = scan.nextLine();
			System.out.println("Digite sua senha:");
			String senha = scan.nextLine();
			login = confereEmailSenha(pessoa, senha, nomeEmail);
			if (login[0] == 0) {
				tentativa += 1;
				try {
					throw new LoginOuSenhaIncorretaException();
				}catch (LoginOuSenhaIncorretaException e) {
					System.out.println(e.getMessage());
					System.out.println((3 - tentativa) + " Tentativas Restantes");
				}
			}
		}
		if (login[0] == 0) {
			System.exit(0);
		}
		return pessoa.get(login[1]);
	}
	private static Integer[] confereEmailSenha(ArrayList<Pessoa> pessoa, String senha, String nomeEmail) {
		Integer[] confere = {0,null};
		for (int i = 0; i < pessoa.size() ; i ++) {
			Pessoa pessoa1 = pessoa.get(i);
			if ((pessoa1.getConta().equals(nomeEmail)||pessoa1.getNome().equals(nomeEmail)) && pessoa1.getSenha().equals(senha)) {
				confere[0] = 1;
				confere[1] = i;
				return  confere;
			}
		}
		return  confere;
	}
	private static void abastecerPermissao(Scanner scan, Caixa caixa) {
		System.out.println("Para poder abastecer, digite o codigo de Seguranca");
		String codigo = scan.next();
		if(caixa.confereCodigo(codigo)) {
			menuNotas();
			int opcao = scan.nextInt();
			if (opcao == 1 ||opcao == 2|| opcao == 3||opcao == 4 ) {
				abastecerEnviar(opcao, caixa, scan);
			}else {
				opcaoInexistente();
			}
		}else {
			try {
				throw new CodigoSegurancaIncorretoException(codigo);
			} catch (CodigoSegurancaIncorretoException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
	}
	private static void abastecerEnviar(int opcao, Caixa caixa, Scanner scan) {
		System.out.println("Digite a quantidade: ");
		int quantidade = scan.nextInt();
		caixa.abastecer(opcao, quantidade);
		System.out.println("Valor total no caixa: R$"+caixa.atualizaTotal()+",00.\n");
	}
	private static void opcaoInexistente() {
		try {
			throw new OpcaoInexistenteException();
		} catch (OpcaoInexistenteException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("Ocorreu algum erro! Digite novamente");
		}
	}
	private static void sacar (Scanner scan, Caixa caixa, Pessoa pessoa) {
		System.out.println("Digite a quantidade desejada para saque: ");
		int valorSaque = scan.nextInt();
		if (pessoa.getSaldo() < valorSaque) {
			try {
				throw new ValorMaiorQueSaldoException(pessoa.getSaldo());
			}catch (ValorMaiorQueSaldoException e) {
				System.out.println(e.getMessage());
			}
		}else {
			caixa.liberanotas(valorSaque, pessoa);
		}
	}
	private static void menuNotas() {
		System.out.println("Escolha qual nota deseja abastecer: ");
		System.out.println("1 - Notas de 10.");
		System.out.println("2 - Notas de 20.");
		System.out.println("3 - Notas de 50.");
		System.out.println("4 - Notas de 100.");
	}
	private static void menu (Pessoa pessoa) {
		System.out.println("Escolha uma op��o abaixo: ");
		if (pessoa.isAutorizacao()) {
			System.out.println("1 - Sacar");
			System.out.println("2 - Abastecer");
			System.out.println("3 - Sair");
		}else {
			System.out.println("1 - Sacar");
			System.out.println("2 - Sair");
		}

	}
}
