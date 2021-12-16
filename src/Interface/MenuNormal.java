package Interface;

import javax.swing.JFrame;

import BancoSistema.Pessoa;

class MenuNormal extends JFrame{
	
	
	
	public MenuNormal(Pessoa pessoa) {
		setLayout(null);

		
		
		
		setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}