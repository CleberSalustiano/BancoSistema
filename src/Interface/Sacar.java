package Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BancoSistema.Caixa;
import BancoSistema.Dados;
import BancoSistema.Pessoa;
import BancoSistema.ValorMaiorQueSaldoException;

class Sacar extends JFrame{
	
	JButton sacar, saldo, sair;
	JLabel tBemVind, tsaldo, tsaque, tretorno; 
	Font font = new Font("Arial", Font.PLAIN, 16);
	Font font2 = new Font("Arial", Font.PLAIN, 14);

	JTextField saque;
	Caixa caixa = new Caixa();

	
	public Sacar(Pessoa pessoa, ArrayList<Pessoa> pessoas) {
		caixa.lerNotas();
		setLayout(null);
		sacar = new JButton("Sacar");
		saldo = new JButton("Saldo");
		sair = new JButton("Sair");
		saque = new JTextField();
		tBemVind = new JLabel("Bem vindo, " + pessoa.getNome());
		tBemVind.setFont(font);
		tsaldo= new JLabel("");
		tsaldo.setFont(font);
		tsaque = new JLabel("Digite o valor que deseja sacar: ");
		tretorno = new JLabel("");
		tretorno.setFont(font2);

		tretorno.setBounds(170, 270, 400, 200);
		tsaque.setBounds(170, 230, 400, 40);
		saque.setBounds(170, 270, 250, 40);
		tsaldo.setBounds(170, 120, 400, 40);
		tBemVind.setBounds(170, 40, 400, 40);
		sacar.setBounds(170, 80, 70, 40);
		saldo.setBounds(260, 80, 70, 40);
		sair.setBounds(350, 80, 70, 40);
		
		add(tretorno);
		add(tsaque);
		add(saque);
		add(sacar);
		add(saldo);
		add(sair);
		add(tBemVind);
		add(tsaldo);
		
		sacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorSaque = Integer.parseInt(saque.getText());
				if (pessoa.getSaldo() < valorSaque) {
					try {
						throw new ValorMaiorQueSaldoException(pessoa.getSaldo());
					} catch (ValorMaiorQueSaldoException ae) {
						System.out.println(ae.getMessage());
						tretorno.setText("Valor menor do que o saldo");
					}
				} else {
					caixa.liberanotasInterface(valorSaque, pessoa, pessoas, tretorno);
					
					
				}
			}
			
		});
		saldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tsaldo.setText("Saldo: " + pessoa.getSaldo());
			}
		});
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();				
			}
		});
		
	
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}