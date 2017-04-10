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
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	 // Recopier la meme methode que le action ??
	    	 //System.out.println("entréé");
	    	 	Window window = Window.getInstance();
	            window.getInputTextArea().setText(null);

	    	 
	     }
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void writeArea(){
    	Window window = Window.getInstance();
    	
		final StyledDocument doc = window.getChatTextArea().getStyledDocument();

    	try {
		    doc.insertString(doc.getLength(), window.getUsernameField() + " : " + window.getInputTextArea().getText()+"\n", null );

		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
            } catch (Exception ex) {
            	writeArea();
            }
            
            window.getInputTextArea().setText("");
            window.getInputTextArea().requestFocus();
        }

        window.getInputTextArea().setText("");
        window.getInputTextArea().requestFocus();
    
		
	}

}
