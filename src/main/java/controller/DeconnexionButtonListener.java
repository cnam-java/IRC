package controller;

import io.ConnexionWindow;
import io.Window;
import json.Message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class DeconnexionButtonListener implements ActionListener  { 
	
	private JTextArea chatTextArea;
	
    public void actionPerformed(ActionEvent evt) {                                                 
        
        sendDisconnect();
        Window window = Window.getInstance();
    	window.dispose();
    	ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    	connexionwindow.setVisible(true);
    	connexionwindow.setLocationRelativeTo(null);
        Disconnect();
    }
    
    public void sendDisconnect() {
    	ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    	Message mess = new Message();
    	String disconnectMess = mess.exitMessage();
        String bye = (connexionwindow.getUsername() + ": :Déconnecté");
         try{

        	 chatTextArea.append(bye);
             ServerConnection server = ServerConnection.getInstance();
             server.write(disconnectMess); 
             
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
