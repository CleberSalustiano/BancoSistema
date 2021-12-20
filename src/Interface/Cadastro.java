package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BancoSistema.Dados;
import BancoSistema.Pessoa;

public class Cadastro extends JFrame {
	
	ArrayList<Pessoa> pessoas = new ArrayList<>();
	JTextField nome, conta;
	JPasswordField senha, confirmSenha;
	JLabel nomeT, contaT, senhaT, confirSenhaT, retornoT, titulo;
	JButton cadastrar, sair;
	Font font = new Font("Arial", Font.PLAIN, 32);
	Font retorno = new Font("Arial", Font.PLAIN, 18);
	Dados dados = new Dados();
	

	
	public Cadastro() {
		dados.pessoasCadastradas(pessoas);
		setLayout(null);
		titulo = new JLabel ("Crie a sua conta");
		titulo.setFont(font);
		nome = new JTextField (30);
		conta = new JTextField (20);
		senha = new JPasswordField(8);
		confirmSenha = new JPasswordField (8);
		nomeT = new JLabel ("Nome:");
		contaT = new JLabel ("Conta:");
		senhaT = new JLabel ("Senha:");
		confirSenhaT = new JLabel ("Confirme sua senha:");
		retornoT = new JLabel("");
		retornoT.setFont(retorno);
		cadastrar = new JButton("Cadastrar");
		sair = new JButton("Sair");

		sair.setBounds(500, 30, 80, 30);
		titulo.setBounds(175, 95, 300, 50);
		nomeT.setBounds(140, 165, 300, 30);
		nome.setBounds(140, 190, 300, 30);
		contaT.setBounds(140, 215, 300, 30);
		conta.setBounds(140, 240, 300, 30);
		senhaT.setBounds(140, 265, 300, 30);
		senha.setBounds(140, 290, 300, 30);
		confirSenhaT.setBounds(140, 315, 300, 30);
		confirmSenha.setBounds(140, 340, 300, 30);
		retornoT.setBounds(140, 420, 300, 30);
		cadastrar.setBounds(230, 380, 120, 30);

		
		
		cadastrar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				char[] senhaChar = senha.getPassword();
				String senhaS = String.valueOf(senhaChar);
				char[] confirmSenhaChar = confirmSenha.getPassword();
				String confirmsenhaS = String.valueOf(confirmSenhaChar);
				if(senhaS.equals("") || confirmsenhaS.equals("") || nome.getText().equals("")|| conta.getText().equals("")) {
					retornoT.setText("Preencha todos os campos");
					retornoT.setForeground(Color.red);
				}
				else if (senhaS.equals(confirmsenhaS)) {
					retornoT.setText(dados.cadastrarPessoaInterface(pessoas, nome.getText(), conta.getText(), senhaS));
					if (retornoT.getText().equals("Email já cadastrado!")) {
						retornoT.setForeground(Color.red);
					}
					else {
						Login login = new Login();
						dispose();
					}
					
				}
				else {
					retornoT.setText("As senhas não são iguais");
					retornoT.setForeground(Color.red);
				}
			}
				
		});
		
		sair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();
			}
		});
		
		add(sair);
		add(retornoT);
		add(titulo);
		add(cadastrar);
		add(nomeT);
		add(contaT);
		add(senhaT);
		add(confirSenhaT);
		add(conta);
		add(senha);
		add(nome);
		add(confirmSenha);
		
		
		
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}