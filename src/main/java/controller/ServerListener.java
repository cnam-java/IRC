package controller;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import io.Window;

public class ServerListener extends Thread {

	public void run() {
		// TODO Auto-generated method stub
		while (true){
			ServerConnection server = ServerConnection.getInstance();
			String response = server.read();
			if(response != null){
			Window window = Window.getInstance();
			final StyledDocument doc = window.getChatTextArea().getStyledDocument();
			try {
				doc.insertString(doc.getLength(),response+"\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}

}
