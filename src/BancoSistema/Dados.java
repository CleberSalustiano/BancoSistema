package BancoSistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dados {

	public void pessoasCadastradas(ArrayList<Pessoa> pessoa) {
		File arq = new File("C:\\dados.txt");

		try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";

			while ((linha = bufferedReader.readLine()) != null) {
				String[] resLinha = linha.split(", ");
				pessoa.add(new Pessoa(resLinha[0], resLinha[1], resLinha[2], Boolean.parseBoolean(resLinha[4]),
						Integer.parseInt(resLinha[3])));
			}
			fileReader.close();
			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cadastrarPessoa(ArrayList<Pessoa> pessoa, Scanner scan) {
		System.out.println("Informe seu nome: ");
		String nome = scan.nextLine();
		nome = scan.nextLine();
		System.out.println("Informe seu email: ");
		String email = scan.nextLine();
		System.out.println("Informe sua senha: ");
		String senha = scan.nextLine();
		try {
			FileWriter arq = new FileWriter("C:\\dados.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			for (int i = 0; i < pessoa.size(); i++) {
				gravarArq.printf("%s, %s, %s, %s, %b\n", pessoa.get(i).getNome(), pessoa.get(i).getConta(), pessoa.get(i).getSenha(), pessoa.get(i).getSaldo(), pessoa.get(i).isAutorizacao());
			}
			gravarArq.printf("%s, %s, %s, %s, %b\n", nome, email, senha, 2000, false);
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
