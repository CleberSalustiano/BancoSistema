package Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		login.setBounds(140, 340, 300, 30);
		senha.setBounds(140, 380, 300, 30);
		entrar.setBounds(230, 420, 120, 30);
		cadastro.setBounds(230, 460, 120, 30);
		tlogin.setBounds(270, 300, 100, 30);
		
		add(login);
		add(cadastro);
		add(senha);
		add(tlogin);
		add(entrar);
		
		ActionListener al = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String conta = login.getText();
				char[] password = senha.getPassword();
				
			}
			
		};
		
		
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		
		
	}
}