package controller;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import org.json.JSONObject;

import io.Window;

public class ServerListener extends Thread {

	public void run() {
		// TODO Auto-generated method stub
		while (true){
			ServerConnection server = ServerConnection.getInstance();
			String response = server.read();
			if(response != null){
				JSONObject json = new JSONObject(response);

				if(json.get("nickname").toString().toUpperCase().equals("SERVER")){
					SendButtonListener objectjson = new SendButtonListener();
					objectjson.writeArea(json.get("post").toString(), "");
				}
				else{
					SendButtonListener objectjson = new SendButtonListener();
					objectjson.writeArea(json.get("post").toString(), json.get("nickname").toString());
				}
			}
		}
		
	}

}
