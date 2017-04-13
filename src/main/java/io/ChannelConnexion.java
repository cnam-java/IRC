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

import controller.ChannelButtonListener;
import controller.ConnectionButtonListener;
import controller.SendButtonListener;

public class ChannelConnexion extends JFrame{
	
    // Déclaration des variables
    private JLabel channelLabel;
    static private JTextField channelField;
    private JButton connectButton;
    
    private static ChannelConnexion INSTANCE = new ChannelConnexion();
    
    ChannelConnexion() {
        initConnexion();
        this.setSize(500, 250);
    }
    
    public static ChannelConnexion getInstance() {
		return INSTANCE;
	}
    
    // Récupération du nom du cannal
    public String getChannel(){   
        return channelField.getText();
    }
    
    public void setChannelFiel(){
    	channelField.setText(""); 
    }

    // Initialisation de la fenêtre de connexion
    private void initConnexion() {
    	
    	  channelLabel = new JLabel();
    	  channelField = new JTextField();
         
          connectButton = new JButton();
          JPanel pan = new JPanel();
          this.setContentPane(pan);
        
          channelLabel.setText("Enter a channel to join or to create : ");
          channelLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      Toolkit kit = Toolkit.getDefaultToolkit();
	       
	       // Modifier l'icône de JFrame
	      Image img = kit.getImage("images/hungry_icon.png");
	      setIconImage(img);
          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Chat IRC CNAM");
          connectButton.setText("Connexion");
          
          // Action sur le bouton de connexion, message d'erreur si manque d'informations
          connectButton.addActionListener(new ChannelButtonListener());
          channelField.addKeyListener(new ChannelButtonListener());
          
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
              					.addComponent(channelField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
              					.addGap(74))
              				))
              				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
              					.addComponent(channelLabel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
              					.addContainerGap())
              				))
          );
          layout.setVerticalGroup(
              	layout.createParallelGroup(Alignment.TRAILING)
              		.addGroup(layout.createSequentialGroup()
              			.addGap(50)
              			.addComponent(channelLabel)
              			.addPreferredGap(ComponentPlacement.RELATED)
              			.addComponent(channelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              			.addPreferredGap(ComponentPlacement.RELATED)
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