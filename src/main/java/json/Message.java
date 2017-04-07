package json;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import io.ConnexionWindow;
import io.MainClient;
import io.Window;

public class Message {

	private static final Logger LOG = Logger.getLogger(Message.class.getName());
	
	public Message() {
		// useless
	}
	
	public String connectMessage(String nickname, String serverIp){
		
		String message = "";
		
		JSONArray args = new JSONArray();		
		args.put(serverIp);
		
		JSONObject jsonConnect = new JSONObject();
		jsonConnect.put("args", args);
		jsonConnect.put("post", "#CONNECT");
		jsonConnect.put("nickname", nickname);
		
		message = jsonConnect.toString();
		LOG.log(Level.INFO, "New message of connection created : "+message);
		System.out.println(message); 
		return message;
	}
	
	public String textMessage( String nickname, String userMessage){
		
		String message = "";
		
		JSONObject jsonText = new JSONObject();
		
		jsonText.put("post", userMessage);
		jsonText.put("nickname", nickname);
		
		message = jsonText.toString();
		LOG.log(Level.INFO, "New message text created : "+message);
		return message;
	}
	
	public String joinMessage(String channel) {
		
		String message = "";
		
		JSONObject jsonJoin = new JSONObject();
		
		jsonJoin.put("args", channel);
		jsonJoin.put("post", "#JOIN");
		
		message = jsonJoin.toString();
		LOG.log(Level.INFO, "New join message created :"+message);
		return message;
	}
	
	public String quitMessage() {
		
		String message = "";
		
		JSONObject jsonQuit = new JSONObject();
		
		jsonQuit.put("post", "#QUIT");
		
		message = jsonQuit.toString();
		LOG.log(Level.INFO, "New quit message created :"+message);
		return message;
	}

	public String exitMessage() {
		
		String message = "";
		
		JSONObject jsonQuit = new JSONObject();
		
		jsonQuit.put("post", "#EXIT");
		
		message = jsonQuit.toString();
		LOG.log(Level.INFO, "New exit message created :"+message);
		return message;
	}
}
