package controller;

import io.ConnexionWindow;
import io.Window;
import json.Message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.util.Arrays;

import javax.swing.ImageIcon;
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
	    	 //System.out.println("entr��");
	    	 Send();
	    	 
	     }
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	     if (e.getKeyCode() == KeyEvent.VK_ENTER)
	     {
	    	 // Recopier la meme methode que le action ??
	    	 //System.out.println("entr��");
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

		//©LittleSnake42	
		String msg = window.getInputTextArea().getText();
		
		// Split the string and check each word
		String[] words = msg.split(" ");
		
		for (int i = 0; i < words.length; i++) {

			if (Arrays.asList(window.EMOS).contains(words[i])) {
				window.chatTextArea.setCaretPosition(doc.getLength());
				window.chatTextArea.insertIcon(new ImageIcon("images/"+words[i]+".png"));
			} 
			else {
				if (i != 0) {
					msg = " " + words[i];//split all spaces
				} else {
					msg = words[i];
				}
				try {
					doc.insertString(doc.getLength(), msg, null);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}

			}
			
			// si dernier mot (ou emo) \n
			if (i+1 == words.length)
				try {
					doc.insertString(doc.getLength(), "\n", null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		// END ©LittleSnake
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
    	ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
        String nothing = "";
        if ((window.getInputTextArea().getText()).equals(nothing)) {
        	window.getInputTextArea().setText("");
        	window.getInputTextArea().requestFocus();
        } else {
            try {
            	Message mess = new Message();
            	String textMess = mess.textMessage(connexionwindow.getUsername(), window.getMessage());
            	writer.write(textMess); 
            	//©LittleSnake42
            	writer.newLine();// If not msg not read from server
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
