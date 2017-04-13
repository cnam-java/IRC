package controller;

import io.Window;

public class ServerListener extends Thread {

	public void run() {
		// TODO Auto-generated method stub
		while (true){
			ServerConnection server = ServerConnection.getInstance();
			String response = server.read();
			if(response != null){
			Window window = Window.getInstance();
			window.getChatTextArea().setText(response+"\n");
			window.getChatTextArea().setText("weshhh\n");
			System.out.println(response);
			}
		}
		
	}

}
