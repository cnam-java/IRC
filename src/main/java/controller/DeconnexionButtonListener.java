package controller;

import io.ConnexionWindow;
import io.CustomLogger;
import io.Window;
import json.Message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.JTextArea;

public class DeconnexionButtonListener implements ActionListener  { 
	
	private JTextArea chatTextArea;
	
    public void actionPerformed(ActionEvent evt) {                                                 
        
        sendDisconnect();
        Disconnect();
        Window window = Window.getInstance();
    	window.dispose();
    	ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    	connexionwindow.setVisible(true);
    	connexionwindow.setLocationRelativeTo(null);
    	connexionwindow.setUsername();
    	connexionwindow.setIpField(); 
    	
    }
    
    public void sendDisconnect() {

    	CustomLogger logger = new CustomLogger();
    	
    	ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    	String nickname = connexionwindow.getUsername();
    	Message mess = new Message();
    	String disconnectMess = mess.exitMessage(nickname);
        try{

            ServerConnection server = ServerConnection.getInstance();
            server.write(disconnectMess); 

            logger.log(Level.INFO, "DeconnexionButtonListener", "actionPerformed", nickname.toUpperCase()+" disconnected from server.");
            
         } catch (Exception e) {
             chatTextArea.append("Impossible d'envoyer le message déconnecté.\n");
         }
 
       }

     public void Disconnect() {

         try {
                //chatTextArea.append("Déconnecter.\n");
                ServerConnection server = ServerConnection.getInstance();
                server.closeConnection(); 
                
         } catch(Exception ex) {
                chatTextArea.append("Echec de la déconnexion. \n");
         }

       }

}
