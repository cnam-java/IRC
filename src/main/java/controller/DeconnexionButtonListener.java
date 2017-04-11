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
	private BufferedWriter writer;
    public void actionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
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
             writer.write(disconnectMess); // Sends server the disconnect signal.
             writer.flush(); // flushes the buffer
         } catch (Exception e) {
             chatTextArea.append("Impossible d'envoyer le message déconnecté.\n");
         }
 
       }

     public void Disconnect() {

         try {
                 chatTextArea.append("Déconnecter.\n");
                //sock.close();
         } catch(Exception ex) {
                chatTextArea.append("Echec de la déconnexion. \n");
         }

       }

}
