package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;

import io.ChannelConnexion;
import io.ConnexionWindow;
import io.CustomLogger;
import io.Window;
import json.Message;

public class ChangeChannelButtonListener implements ActionListener {

	public ChangeChannelButtonListener() {
		// TODO Auto-generated constructor stub
	}
    ArrayList<String> userList = new ArrayList();
    Boolean isConnected = false;

	public void actionPerformed(ActionEvent evt) {
		Disconnect();
	}
	
	public void keyPressed(KeyEvent e)
	{
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	 Disconnect();
	    	 
	     }
	}
	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void Disconnect(){
		
		CustomLogger logger = new CustomLogger();
		ChannelConnexion channel = ChannelConnexion.getInstance();
		Window window = Window.getInstance();
		ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
		
		String user = connexionwindow.getUsername();
		
  		Message mess = new Message();
  		
		ServerConnection server = ServerConnection.getInstance();
		server.write(mess.quitMessage(user));
		String name = channel.getChannel();
        window.dispose();
        channel.setVisible(true);
        channel.setChannelFiel();
        channel.setLocationRelativeTo(null);
		logger.log(Level.INFO, "ChannelButtonListener", "Connect", user.toUpperCase()+" has quit channel"+name.toUpperCase()+".");
		
	}
}
