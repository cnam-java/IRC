package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller{

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	 public void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
	        // TODO add your handling code here:
	            if (isConnected == false) {
	            username = usernameField.getText();
	            usernameField.setEditable(false);



	            try {
	                sock = new Socket(serverIP, Port);
	                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
	                reader = new BufferedReader(streamreader);
	                writer = new PrintWriter(sock.getOutputStream());
	                writer.println(username + ":est connecté.:Connecté"); // Displays to everyone that user connected.
	                writer.flush(); // flushes the buffer
	                isConnected = true; // Used to see if the client is connected.
	            } catch (Exception ex) {
	                chatTextArea.append("Impossible de se connecter, réessayer !\n");
	                usernameField.setEditable(true);
	            }
	            ListenThread();
	        } else if (isConnected == true) {
	            chatTextArea.append("Vous êtes déjà connecté. \n");
	        }
	    }                                             

	    public void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
	        // TODO add your handling code here:
//	        sendDisconnect();l
	        Disconnect();
	    }                                       
	    
	    
	    

	    public void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
	        // TODO add your handling code here:
	        String nothing = "";
	        if ((inputTextArea.getText()).equals(nothing)) {
	            inputTextArea.setText("");
	            inputTextArea.requestFocus();
	        } else {
	            try {
//	               writer.println(username + ":" + inputTextArea.getText() + ":" + "Chat");
	               writer.flush(); // flushes the buffer
	            } catch (Exception ex) {
	                chatTextArea.append("Message non envoyé \n");
	            }
	            
	            inputTextArea.setText("");
	            inputTextArea.requestFocus();
	        }

	        inputTextArea.setText("");
	        inputTextArea.requestFocus();
	    }  
	    
	    public void sendDisconnect() {
	    
	           String bye = (username + ": :Déconnecté");
	            try{
	                writer.println(bye); // Sends server the disconnect signal.
	                writer.flush(); // flushes the buffer
	            } catch (Exception e) {
	                chatTextArea.append("Impossible d'envoyer le message déconnecté.\n");
	            }
	    
	          }

	        public void Disconnect() {

	            try {
	                    chatTextArea.append("Déconnecter.\n");
	                   sock.close();
	            } catch(Exception ex) {
	                   chatTextArea.append("Échec de la déconnexion. \n");
	            }
	            isConnected = false;
	            usernameField.setEditable(true);
	            usersList.setText("");

	          }
}


