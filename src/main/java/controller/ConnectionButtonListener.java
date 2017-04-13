package controller;

//import io.ChannelConnexion;
import io.ClientException;
import io.ConnexionWindow;
import io.CustomLogger;
import io.MainClient;
import io.Window;
import json.Message;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ConnectionButtonListener implements ActionListener, KeyListener{ 
	    BufferedWriter writer;
	    ArrayList<String> userList = new ArrayList();
	    Boolean isConnected = false;
	    private static final Pattern PATTERN = Pattern.compile(
	            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");


    public void actionPerformed(ActionEvent evt) {
    	Connect();
    }

    public void keyPressed(KeyEvent e)
	{
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	 Connect();
	    	 
	     }
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void Connect(){
	
		ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
		String ipString = connexionwindow.getIpField();
		CustomLogger logger = new CustomLogger();
		
	  	   if(connexionwindow.getUsername().isEmpty() && connexionwindow.getIpField().isEmpty()){
	  		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur et entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE);
	  	  }
	  	   else if(connexionwindow.getUsername().isEmpty()){
	    		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	  }
	  	  else if(connexionwindow.getIpField().isEmpty()){
	  		  JOptionPane.showMessageDialog(null, "Entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE); 	 
	  	  }
	  	  else if(!validate(ipString)){
	  		JOptionPane.showMessageDialog(null, "Entrez une adresse ip valide", "Information", JOptionPane.INFORMATION_MESSAGE);
	  	  } else{

	  		Message mess = new Message();
	  		mess.connectMessage(connexionwindow.getUsername(),connexionwindow.getIpField());
  	        //ChannelConnexion channel = ChannelConnexion.getInstance();
  	        connexionwindow.dispose();
  	        //channel.setVisible(true);
  	        //channel.setLocationRelativeTo(null);
  	  		logger.log(Level.INFO, "ConnectionButtonListener", "Connect", "ChatWindow instanciated and launched");
	  	  }
		
	}
	
    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }


}
