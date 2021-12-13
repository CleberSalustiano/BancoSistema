package BancoSistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Dados {

	public void pessoasCadastradas(ArrayList<Pessoa> pessoa) {
		File arq = new File("C:\\dados.txt");
		
		try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader bufferedReader = new BufferedReader (fileReader);
			String linha = "";
			
			while ( ( linha = bufferedReader.readLine() ) != null) {
		        String[] resLinha = linha.split(", ");
		        pessoa.add(new Pessoa(resLinha[0], resLinha[1], resLinha[2], Boolean.parseBoolean(resLinha[4]), Integer.parseInt(resLinha[3])));
			}
	        fileReader.close();
	        bufferedReader.close();
			
		} catch (Exception e) {
	    	e.printStackTrace();
		}
	
	}

}
