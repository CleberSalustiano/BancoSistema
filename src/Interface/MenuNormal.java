package Interface;

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

import BancoSistema.Pessoa;

class MenuNormal extends JFrame{
	
	JButton sacar, saldo, sair;
	JLabel tBemVind, tsaldo; 
	Font font = new Font("Arial", Font.PLAIN, 16);

	
	public MenuNormal(Pessoa pessoa, ArrayList<Pessoa> pessoas) {
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("banco.png"));
		} catch (IOException e) {
			e.printStackTrace();
			myPicture = null;
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
		picLabel.setBounds(170, 220, 240, 250);
		setLayout(null);
		sacar = new JButton("Sacar");
		saldo = new JButton("Saldo");
		sair = new JButton("Sair");
		tBemVind = new JLabel("Bem vindo, " + pessoa.getNome());
		tBemVind.setFont(font);
		tsaldo= new JLabel("");
		tsaldo.setFont(font);
		
		tsaldo.setBounds(170, 120, 400, 40);
		tBemVind.setBounds(170, 40, 400, 40);
		sacar.setBounds(170, 80, 70, 40);
		saldo.setBounds(260, 80, 70, 40);
		sair.setBounds(350, 80, 70, 40);
		
		add(sacar);
		add(saldo);
		add(sair);
		add(tBemVind);
		add(tsaldo);
		
		sacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sacar sacar = new Sacar(pessoa, pessoas);
				dispose();				
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