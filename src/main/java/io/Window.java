package io;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window {

	public Window() {
		JFrame window = new JFrame();
		
		
		JButton bouton =new JButton("clique");
		window.add(bouton);
		window.setTitle("IRC");
		window.setSize(400, 500);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
