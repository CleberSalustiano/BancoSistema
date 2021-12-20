package BancoSistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;

public class Dados {

	public void pessoasCadastradas(ArrayList<Pessoa> pessoas) {
		File arq = new File("dados.txt");

		try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";

			while ((linha = bufferedReader.readLine()) != null) {
				String[] resLinha = linha.split(", ");
				pessoas.add(new Pessoa(resLinha[0], resLinha[1], resLinha[2], Boolean.parseBoolean(resLinha[4]),
						Integer.parseInt(resLinha[3])));
			}
			fileReader.close();
			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean cadastrarPessoa(ArrayList<Pessoa> pessoas, Scanner scan) {
		System.out.println("Informe seu nome: ");
		String nome = scan.nextLine();
		nome = scan.nextLine();
		System.out.println("Informe seu email: ");
		String email = scan.nextLine();
		System.out.println("Informe sua senha: ");
		String senha = scan.nextLine();
		Boolean bool = false;
		for (int i = 0; i < pessoas.size(); i++) {
			if (email.equals(pessoas.get(i).getConta())) {
				bool = true;
			}
		}
		if (bool == true) {
			System.out.println("Usuário já cadastrado");
		} else {
			try {
				FileWriter arq = new FileWriter("dados.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				for (int i = 0; i < pessoas.size(); i++) {
					gravarArq.printf("%s, %s, %s, %s, %b\n", pessoas.get(i).getNome(), pessoas.get(i).getConta(),
							pessoas.get(i).getSenha(), pessoas.get(i).getSaldo(), pessoas.get(i).isAutorizacao());
				}
				gravarArq.printf("%s, %s, %s, %s, %b\n", nome, email, senha, 2000, false);
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bool;

	}
	
	public String cadastrarPessoaInterface(ArrayList<Pessoa> pessoas, String nome, String email, String senha) {
		Boolean bool = false;
		for (int i = 0; i < pessoas.size(); i++) {
			if (email.equals(pessoas.get(i).getConta())) {
				bool = true;
				break;
			}			
		}
		if (bool == true) {
			return "Email já cadastrado!";
		} else {
			try {
				FileWriter arq = new FileWriter("dados.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				for (int i = 0; i < pessoas.size(); i++) {
					gravarArq.printf("%s, %s, %s, %s, %b\n", pessoas.get(i).getNome(), pessoas.get(i).getConta(),
							pessoas.get(i).getSenha(), pessoas.get(i).getSaldo(), pessoas.get(i).isAutorizacao());
				}
				gravarArq.printf("%s, %s, %s, %s, %b\n", nome, email, senha, 2000, false);
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "Usuário cadastrado com sucesso!";
		}
	}

	public void atualizaPessoa(ArrayList<Pessoa> pessoas, Pessoa pessoa) {
		pessoas.set(pessoa.getID(), pessoa);
		try {
			FileWriter arq = new FileWriter("dados.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			for (int i = 0; i < pessoas.size(); i++) {
				gravarArq.printf("%s, %s, %s, %s, %b\n", pessoas.get(i).getNome(), pessoas.get(i).getConta(),
						pessoas.get(i).getSenha(), pessoas.get(i).getSaldo(), pessoas.get(i).isAutorizacao());
			}
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
