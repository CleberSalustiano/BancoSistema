package BancoSistema;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Interface {
		
}

class Login extends JFrame{
	JTextField login;
	JPasswordField senha;
	JButton entrar;
	JButton cadastro;
	JLabel tlogin, tretorno;
	Font font = new Font("Arial", Font.PLAIN, 20);
	
	public Login() {
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("banco.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
			picLabel.setBounds(170, 20, 240, 250);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		setLayout(null);
		login = new JTextField(20);
		senha = new JPasswordField(8);
		entrar = new JButton("Entrar");
		cadastro = new JButton("Cadastre-se");
		tlogin = new JLabel("Login");
		tlogin.setFont(font);
		tretorno = new JLabel("");
		
		login.setBounds(140, 340, 300, 40);
		senha.setBounds(140, 400, 300, 40);
		entrar.setBounds(230, 450, 120, 20);
		cadastro.setBounds(230, 480, 120, 20);
		tlogin.setBounds(270, 300, 100, 30);
		
		add(login);
		add(cadastro);
		add(senha);
		add(tlogin);
		add(entrar);
		
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		
		
	}
}

class MenuNormal extends JFrame{
	
	
	
	public MenuNormal() {
		setLayout(null);

		
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}

class MenuAbastecer extends JFrame{
	
}

