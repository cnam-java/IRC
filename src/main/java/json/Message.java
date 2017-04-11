package json;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class Message {

	public static final Logger logger = Logger.getLogger(Message.class.getName());
	    
	public Message() {

    	
	}
	
	public String connectMessage(String nickname, String serverIp){
		
		JSONArray args = new JSONArray();		
		args.put(serverIp);
		
		JSONObject jsonConnect = new JSONObject();
		jsonConnect.put("args", args);
		jsonConnect.put("post", "#CONNECT");
		jsonConnect.put("nickname", nickname);
		
		String message = jsonConnect.toString();
		logger.log(Level.INFO, "New message of connection created : "+message);
		return message;
	}
	
	public String textMessage( String nickname, String userMessage){
		
		JSONObject jsonText = new JSONObject();
		
		jsonText.put("post", userMessage);
		jsonText.put("nickname", nickname);
		
		String message = jsonText.toString();
		logger.log(Level.INFO, "New message text created : "+message);
		return message;
	}
	
	public String joinMessage(String channel) {
		
		JSONObject jsonJoin = new JSONObject();
		
		jsonJoin.put("args", channel);
		jsonJoin.put("post", "#JOIN");
		
		String message = jsonJoin.toString();
		logger.log(Level.INFO, "New join message created :"+message);
		return message;
	}
	
	public String quitMessage() {
		
		JSONObject jsonQuit = new JSONObject();
		
		jsonQuit.put("post", "#QUIT");
		
		String message = jsonQuit.toString();
		logger.log(Level.INFO, "New quit message created :"+message);
		return message;
	}

	public String exitMessage() {
		
		JSONObject jsonQuit = new JSONObject();
		
		jsonQuit.put("post", "#EXIT");
		
		String message = jsonQuit.toString();
		logger.log(Level.INFO, "New exit message created :"+message);
		return message;
	}
}
