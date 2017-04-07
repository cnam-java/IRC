package controller;

import io.ClientException;
import io.ConnexionWindow;
import io.MainClient;
import io.Window;

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

import javax.swing.JOptionPane;

public class ConnectionButtonListener implements ActionListener, KeyListener{ 
	    BufferedWriter writer;
	    ArrayList<String> userList = new ArrayList();
	    Boolean isConnected = false;

    public void actionPerformed(ActionEvent evt) {
    	Connect();
    }

    public void keyPressed(KeyEvent e)
	{
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	// Recopier la meme methode que le action ??
	    	 //System.out.println("entréé");
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
	  	   if(connexionwindow.getUsername().isEmpty() && connexionwindow.getIpField().isEmpty()){
	  		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur et entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE);
	  	  }
	  	   else if(connexionwindow.getUsername().isEmpty()){
	    		  JOptionPane.showMessageDialog(null, "Choissisez un nom d'utilisateur", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	  }
	  	  else if(connexionwindow.getIpField().isEmpty()){
	  		  JOptionPane.showMessageDialog(null, "Entrez une adresse ip", "Information", JOptionPane.INFORMATION_MESSAGE); 	 
	  	  }
	  	  else{
	      	 
	  		//try{
	  			Window window = Window.getInstance();
	  			connexionwindow.dispose();
	  	      	window.setVisible(true);
	  	  		window.setLocationRelativeTo(null);
	  	  		window.setUsernameField(connexionwindow.getUsername());
	  			
//	  			}catch(ClientException e){
//	  				JOptionPane.showMessageDialog(null, "Erreur de connexion avec le server", "Information", JOptionPane.INFORMATION_MESSAGE); 
//	  				
//	  		}
	  	  }
		
	}

}
