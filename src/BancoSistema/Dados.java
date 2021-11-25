package BancoSistema;

import java.util.ArrayList;

public class Dados {

	public void pessoasCadastradas(ArrayList<Pessoa> pessoa) {
		pessoa.add(new Pessoa("Carlos","carlos@email.com","12345",true,200));
		pessoa.add(new Pessoa("Arthur","arthur@email.com","23456",100));
		pessoa.add(new Pessoa("Marcos","marcos@email.com","34567",300));
		pessoa.add(new Pessoa("Cleber","cleber@email.com","12345",1000000));
		pessoa.add(new Pessoa("Joao","joao@email.com","56789",123));
		pessoa.add(new Pessoa("Luana","luana@email.com","56789",220));		
	}

}
