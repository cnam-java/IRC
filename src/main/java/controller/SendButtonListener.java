package controller;

import io.ConnexionWindow;
import io.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class SendButtonListener implements ActionListener, KeyListener  {
	private BufferedWriter writer;
    public void actionPerformed(ActionEvent evt) {
    	Send();
    }
    public void keyPressed(KeyEvent e)
	{
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	 // Recopier la meme methode que le action ??
	    	 //System.out.println("entréé");
	    	 Send();
	    	 
	     }
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void Send(){                                           
        // TODO add your handling code here:
    	
    	Window window = Window.getInstance();
        String nothing = "";
        if ((window.getInputTextArea().getText()).equals(nothing)) {
        	window.getInputTextArea().setText("");
        	window.getInputTextArea().requestFocus();
        } else {
            try {
//      METTRE JSON         writer.println(username + ":" + inputTextArea.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
               window.getChatTextArea().append(window.getUsernameField() + ":" + window.getInputTextArea().getText());
            } catch (Exception ex) {
                window.getChatTextArea().append("Message non envoyé \n");
            }
            
            window.getInputTextArea().setText("");
            window.getInputTextArea().requestFocus();
        }

        window.getInputTextArea().setText("");
        window.getInputTextArea().requestFocus();
    
		
	}

}
