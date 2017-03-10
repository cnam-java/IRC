package io;

import java.awt.Color; 
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Window extends JFrame {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Window(){             
    this.setTitle("Chat IRC Cnam");
    this.setSize(800, 650);
    this.setLocationRelativeTo(null);
    
    JButton bouton = new JButton("Envoyer !");
 
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    pan.add(bouton);
    pan.setLayout(new FlowLayout());
    
    //Définition de sa couleur de fond
    pan.setBackground(Color.cyan);  
   
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);               
    this.setVisible(true);
  }       
}