package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BancoSistema.Caixa;

class MenuAbastecer extends JFrame {
	JTextField notas10, notas20, notas50, notas100;
	JLabel notas10T, notas20T, notas50T, notas100T, retornoT, titulo;
	JButton abastecer, sair;
	Font font = new Font("Arial", Font.PLAIN, 24);
	Font retorno = new Font("Arial", Font.PLAIN, 15);
	Caixa caixa = new Caixa();

	public MenuAbastecer() {
		setLayout(null);
		titulo = new JLabel("Digite a quantidade que deseja abastecer");
		titulo.setFont(font);
		notas10 = new JTextField(5);
		notas20 = new JTextField(5);
		notas50 = new JTextField(5);
		notas100 = new JTextField(5);
		notas10T = new JLabel("Notas de 10:");
		notas20T = new JLabel("Notas de 20:");
		notas50T = new JLabel("Notas de 50:");
		notas100T = new JLabel("Notas de 100:");
		retornoT = new JLabel("");
		retornoT.setFont(retorno);
		abastecer = new JButton("Abastecer");
		sair = new JButton("Sair");

		sair.setBounds(500, 30, 80, 30);
		titulo.setBounds(70, 95, 500, 50);
		notas10T.setBounds(140, 165, 300, 30);
		notas10.setBounds(140, 190, 300, 30);
		notas20T.setBounds(140, 215, 300, 30);
		notas20.setBounds(140, 240, 300, 30);
		notas50T.setBounds(140, 265, 300, 30);
		notas50.setBounds(140, 290, 300, 30);
		notas100T.setBounds(140, 315, 300, 30);
		notas100.setBounds(140, 340, 300, 30);
		retornoT.setBounds(140, 420, 300, 30);
		abastecer.setBounds(230, 380, 120, 30);

		abastecer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int inotas10 = 0; int inotas20 = 0; int inotas50 = 0; int inotas100 = 0;
				if (notas10.getText().equals("") && notas20.getText().equals("") && notas50.getText().equals("")
						&& notas100.getText().equals("")) {
					retornoT.setText("Prencha um dos campos");
					retornoT.setForeground(Color.red);
				} else {
					try {
						caixa.lerNotas();
						if (!notas10.getText().equals("")) {
							inotas10 = Integer.parseInt(notas10.getText());
						}
						if (!notas20.getText().equals("")) {
							inotas20 = Integer.parseInt(notas20.getText());
						}
						if (!notas50.getText().equals("")) {
							inotas50 = Integer.parseInt(notas50.getText());
						}
						if (!notas100.getText().equals("")) {
							inotas100 = Integer.parseInt(notas100.getText());
						}
						caixa.abastecerInterface(inotas10, inotas20, inotas50, inotas100);
						caixa.escreverNotas();
						retornoT.setText("Abastecimento concluído com sucesso");
						retornoT.setForeground(Color.blue);
					} catch (Exception ae) {
						retornoT.setText("Digite apenas números inteiros nos campos");
						retornoT.setForeground(Color.red);
					}

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
		add(titulo);
		add(notas10T);
		add(notas20T);
		add(notas50T);
		add(notas100T);
		add(notas10);
		add(notas20);
		add(notas50);
		add(notas100);
		add(retornoT);
		add(abastecer);

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}