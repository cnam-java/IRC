package io;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ConnectionButtonListener;
import controller.SendButtonListener;
import json.Message;

public class ConnexionWindow extends JFrame{
	
    // Déclaration des variables
    private JLabel usernameLabel;
    static private JTextField usernameField;
    private JLabel ipLabel;
    static private JTextField ipField;
    private JButton connectButton;
    
    private static ConnexionWindow INSTANCE = new ConnexionWindow();
    
    private ConnexionWindow() {
        initConnexion();
        this.setSize(600, 300);
    }
    
    public static ConnexionWindow getInstance() {
		return INSTANCE;
	}
    
    // Récupération du nom d'utilisateur
    public String getUsername(){   
        return usernameField.getText();
    }
    
    // Récupération du nom d'utilisateur
    public String getIpField(){   
        return ipField.getText();
    }

    // Initialisation de la fenêtre de connexion
    private void initConnexion() {
    	
    	  usernameLabel = new JLabel();
          usernameField = new JTextField();
          ipLabel = new JLabel();
          ipField = new JTextField();
          connectButton = new JButton();
          JPanel pan = new JPanel();
          this.setContentPane(pan);
        
          usernameLabel.setText("Username:");
          ipLabel.setText("Ip du serveur");
          usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
          ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      Toolkit kit = Toolkit.getDefaultToolkit();
	       
	       // Modifier l'icône de JFrame
	      Image img = kit.getImage("images/hungry_icon.png");
	      setIconImage(img);
          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Chat IRC Cnam");
          connectButton.setText("Connexion");
          
          // Action sur le bouton de connexion, message d'erreur si manque d'informations
          connectButton.addActionListener(new ConnectionButtonListener());
          usernameField.addKeyListener(new ConnectionButtonListener());
          ipField.addKeyListener(new ConnectionButtonListener());
          
          // Création de la fenêtre de connexion et des composants
          GroupLayout layout = new GroupLayout(getContentPane());
          getContentPane().setLayout(layout);           
          layout.setHorizontalGroup(
              	layout.createParallelGroup(Alignment.LEADING)
              		.addGroup(layout.createSequentialGroup()
              				.addContainerGap()
              				.addGroup(layout.createParallelGroup(Alignment.LEADING)
                			.addGroup(layout.createSequentialGroup()
                				.addContainerGap())
              				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
              					.addGap(75)
              				.addGroup(layout.createParallelGroup(Alignment.LEADING)
              				.addGroup(layout.createSequentialGroup()
              					.addComponent(connectButton))
              				.addGroup(layout.createSequentialGroup()
              					.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
              					.addGap(74))
              				.addGroup(layout.createSequentialGroup()
              					.addComponent(ipField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
              					.addGap(74)
              					.addContainerGap())))
              				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
              					.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
              					.addContainerGap())
              				.addComponent(ipLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
              				)
          );
          layout.setVerticalGroup(
              	layout.createParallelGroup(Alignment.TRAILING)
              		.addGroup(layout.createSequentialGroup()
              			.addGap(50)
              			.addComponent(usernameLabel)
              			.addPreferredGap(ComponentPlacement.RELATED)
              			.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              			.addPreferredGap(ComponentPlacement.RELATED)
              			.addComponent(ipLabel)
              			.addPreferredGap(ComponentPlacement.RELATED)
              			.addComponent(ipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              			.addGap(18)
              			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
              			.addComponent(connectButton))
              			.addGap(18)
                		.addPreferredGap(ComponentPlacement.RELATED)
              				)
            		  );
                    getContentPane().setLayout(layout);
                    pack();
                    
                    
    }
    
}