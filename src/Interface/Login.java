package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BancoSistema.Caixa;
import BancoSistema.Dados;
import BancoSistema.Pessoa;

class Login extends JFrame {
	
	public static void main(String[] args) {
		Login login = new Login ();
	}
	
	JTextField login;
	JPasswordField senha;
	JButton entrar;
	JButton cadastro;
	JLabel tlogin, tretorno, tconta, tsenha;
	Font font = new Font("Arial", Font.PLAIN, 20);

	public Login() {
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("banco.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
			picLabel.setBounds(170, 20, 240, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}

		setLayout(null);
		login = new JTextField(20);
		senha = new JPasswordField(8);
		entrar = new JButton("Entrar");
		cadastro = new JButton("Cadastre-se");
		tlogin = new JLabel("Login");
		tlogin.setFont(font);
		tconta = new JLabel("Conta:");
		tsenha = new JLabel ("Senha:");
		tretorno = new JLabel("");
		
		login.setBounds(140, 335, 300, 30);
		tconta.setBounds(140, 310, 300, 30);
		tsenha.setBounds(140, 360, 300, 30);
		senha.setBounds(140, 385, 300, 30);
		tretorno.setBounds(210, 500, 200, 20);
		entrar.setBounds(230, 425, 120, 30);
		cadastro.setBounds(230, 465, 120, 30);
		tlogin.setBounds(270, 280, 100, 30);
		
		add(tconta);
		add(tsenha);
		add(login);
		add(cadastro);
		add(senha);
		add(tlogin);
		add(tretorno);
		add(entrar);

		entrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Caixa caixa = new Caixa();
				ArrayList<Pessoa> pessoas = new ArrayList<>();
				Pessoa pessoa = new Pessoa();
				Dados dados = new Dados();
				String conta = login.getText();
				char[] passwordChar = senha.getPassword();
				String password = String.valueOf(passwordChar);
				caixa.lerNotas();
				dados.pessoasCadastradas(pessoas);
				try {
					pessoa = menuLogin(pessoas, password, conta);
					if (pessoa.isAutorizacao()) {
						MenuAbastecer abastecer = new MenuAbastecer();
						dispose();
					}else {
						MenuNormal menu = new MenuNormal(pessoa, pessoas);
						dispose();	
					}
				} catch (Exception e2) {
					tretorno.setText("Usuário e/ou senha inválidos");
					tretorno.setForeground(Color.red);
				}
			}

			private Pessoa menuLogin(ArrayList<Pessoa> pessoas, String password, String conta) {
				Integer[] login = { 0, null };
				login = confereEmailSenha(pessoas, password, conta);
				pessoas.get(login[1]).setID(login[1]);
				return pessoas.get(login[1]);
			}

			private Integer[] confereEmailSenha(ArrayList<Pessoa> pessoa, String senha, String nomeEmail) {
				Integer[] confere = { 0, null };
				for (int i = 0; i < pessoa.size(); i++) {
					Pessoa pessoa1 = pessoa.get(i);
					if ((pessoa1.getConta().equals(nomeEmail) && pessoa1.getSenha().equals(senha))) {
						confere[0] = 1;
						confere[1] = i;
						return confere;
					}
				}
				return confere;
			}
		});
		
		cadastro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				dispose();
				
			}
		});

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}