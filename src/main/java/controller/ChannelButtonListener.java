package controller;

import io.ChannelConnexion;
import io.ConnexionWindow;
import io.CustomLogger;
import io.Window;
import json.Message;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JOptionPane;

public class ChannelButtonListener implements ActionListener, KeyListener{ 
	
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
		
		CustomLogger logger = new CustomLogger();
		ChannelConnexion channelwindow = ChannelConnexion.getInstance();
		ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
		
			if(channelwindow.getChannel().isEmpty()){
				
    		  JOptionPane.showMessageDialog(null, "Enter a channel please :", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	
			} else {
	      	 
				String user = connexionwindow.getUsername();
				String channel = channelwindow.getChannel();
		  		Message mess = new Message();
				mess.joinMessage(channelwindow.getChannel());
				Window window = Window.getInstance();
				channelwindow.dispose();
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				window.setChanelField(channel);
				window.setUsernameField(user);
				logger.log(Level.INFO, "ChannelButtonListener", "Connect", user.toUpperCase()+" has joined channel "+channel.toUpperCase());
				logger.log(Level.INFO, "ChannelButtonListener", "Connect", "Window instantiated and launched");
	  	  }
		
	}

}
