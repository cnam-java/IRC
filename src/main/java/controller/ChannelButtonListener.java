package controller;

import io.ChannelConnexion;
import io.ClientException;
import io.ConnexionWindow;
import io.MainClient;
import io.Window;
//import json.Message;


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

public class ChannelButtonListener implements ActionListener, KeyListener{ 
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
		
		ChannelConnexion channelwindow = ChannelConnexion.getInstance();
		ConnexionWindow usernamewindow = ConnexionWindow.getInstance();
			if(channelwindow.getChannel().isEmpty()){
	    		  JOptionPane.showMessageDialog(null, "Enter a channel please :", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	  }
	  	  else{
	      	 
	  		//try{
//
//	  		  	Message mess = new Message();
//	  		  	mess.connectMessage(connexionwindow.getUsername(),connexionwindow.getIpField());
	  			Window window = Window.getInstance();
	  			channelwindow.dispose();
	  			window.setVisible(true);
	  			window.setLocationRelativeTo(null);
	  	  		window.setChanelField(channelwindow.getChannel());
	  	  		window.setUsernameField(usernamewindow.getUsername());
	  			//MainClient.runClient(SERVER_HOST, NICKNAME);
//	  			}catch(ClientException e){
//	  				JOptionPane.showMessageDialog(null, "Erreur de connexion avec le server", "Information", JOptionPane.INFORMATION_MESSAGE); 
//	  				
//	  		}
	  	  }
		
	}

}
