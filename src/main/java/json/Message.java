package json;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import io.CustomLogger;

public class Message {

	
	public Message() {

    	
	}
	
	public String connectMessage(String nickname, String serverIp){
		
		CustomLogger logger = new CustomLogger();

		JSONArray args = new JSONArray();		
		args.put(serverIp);
		args.put(nickname);
		
		JSONObject jsonConnect = new JSONObject();
		jsonConnect.put("parameter", args);
		jsonConnect.put("post", "#CONNECT");
		jsonConnect.put("nickname", nickname);
		
		String message = jsonConnect.toString();
		logger.log(Level.INFO, "Message", "connectMessage", "New message of connection created : "+message);
		return message;
	}
	
	public String textMessage( String nickname, String userMessage){
		
		CustomLogger logger = new CustomLogger();
		JSONObject jsonText = new JSONObject();
		
		jsonText.put("post", userMessage);
		jsonText.put("nickname", nickname);
		
		String message = jsonText.toString();
		logger.log(Level.INFO, "Message", "textMessage", "New message text created : "+message);
		return message;
	}
	
	public String joinMessage(String channel) {
		
		CustomLogger logger = new CustomLogger();
		JSONObject jsonJoin = new JSONObject();
		
		jsonJoin.put("parameter", channel);
		jsonJoin.put("post", "#JOIN");
		
		String message = jsonJoin.toString();
		logger.log(Level.INFO, "Message", "joinMessage", "New join message created :"+message);
		return message;
	}
	
	public String quitMessage(String nickname) {
		
		CustomLogger logger = new CustomLogger();
		JSONObject jsonQuit = new JSONObject();
		
		jsonQuit.put("nickname", nickname); 
		jsonQuit.put("post", "#QUIT");
		
		String message = jsonQuit.toString();
		logger.log(Level.INFO, "Message", "quitMessage", "New quit message created :"+message);
		return message;
	}

	public String exitMessage(String nickname) {
		
		CustomLogger logger = new CustomLogger();
		JSONObject jsonExit = new JSONObject();
		
		jsonExit.put("nickname", nickname);
		jsonExit.put("post", "#EXIT");
		
		String message = jsonExit.toString();
		logger.log(Level.INFO, "Message", "exitMessage", "New exit message created :"+message);
		return message;
	}
}
