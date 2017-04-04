package io;

import java.awt.BorderLayout;

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

public class ConnexionWindow extends JFrame{
	
    // Déclaration des variables
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel ipLabel;
    private JTextField ipField;
    private JButton connectButton;
    
    public ConnexionWindow() {
        initConnexion();
        this.setSize(600, 300);
    }
    
    // Récupération du nom d'utilisateur
    public String getUsername(){   
        return this.usernameField.getText();
    }

    
    // Initialisation de la fenêtre de connexion
    private void initConnexion() {
    	
    	  final Controller controller = new Controller();
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
          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Chat IRC Cnam");
          connectButton.setText("Connexion");
          
          // Action sur le bouton de connexion, message d'erreur si manque d'informations
          connectButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
            	   if(usernameField.getText().isEmpty() && ipField.getText().isEmpty()){
            		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur et entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE);
            	  }
            	   else if(usernameField.getText().isEmpty()){
              		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur", "Information", JOptionPane.INFORMATION_MESSAGE);
              	  }
            	  else if(ipField.getText().isEmpty()){
            		  JOptionPane.showMessageDialog(null, "Entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE); 	 
            	  }
            	  else{
                	  Window window = new Window();
              		  window.setVisible(true);
            		  window.setLocationRelativeTo(null);
            		  window.getConnexion(usernameField.getText());
            		  dispose();
            	  }
              }
          });

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
    }}