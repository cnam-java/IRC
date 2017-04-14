package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;

import org.json.JSONObject;

import io.ConnexionWindow;
import io.CustomLogger;
import io.Window;

public class ServerConnection {
	
	private static final int SERVER_PORT = 12345;
	private Socket s = null;
	private OutputStream out = null;
	private OutputStreamWriter osw = null;
	private BufferedWriter bw =null;
	private InputStream in = null;
	private InputStreamReader isr = null;
	protected BufferedReader br = null;
	
	public boolean isStarted = false;
	
	private static ServerConnection INSTANCE = new ServerConnection();
	
	public static ServerConnection getInstance(){
		return INSTANCE;
	}
	
	public ServerConnection() {
		
	}
	
	public void openConnection(String ipServer) {
		
		CustomLogger logger = new CustomLogger();
		
		if(this.isStarted){
			logger.log(Level.WARNING, "ServerConnexion", "startConnexion", "Error in starting server connexion : already connected to another server.");	
		}
		
		try{
			this.s = new Socket(InetAddress.getByName(ipServer), SERVER_PORT);
			
			//utils to write into server
			this.out = s.getOutputStream();
			this.osw = new OutputStreamWriter(out, "UTF-8");
			this.bw = new BufferedWriter(osw);
			
			//utils to read from server
			this.in = s.getInputStream();
			this.isr = new InputStreamReader(in, "UTF-8");
			this.br = new BufferedReader(new InputStreamReader(in));
			
			this.isStarted = true;
			logger.log(Level.INFO, "ServerConnection", "startConnection", "Success in opening socket to server!"); 
		
		} catch(IOException e){
			logger.log(Level.SEVERE, "ServerConnection", "startConnection", "IOException when starting connection : "+e);
		}
	}
	
	public void closeConnection() {
		
		CustomLogger logger = new CustomLogger();
		
		try{
			if(this.br != null){
				this.br.close();
			}
			if(this.isr != null){
				this.isr.close();
			}
			if(this.in != null){
				this.in.close();
			}
			if(this.bw != null){
				this.bw.close();
			}
			if(this.osw != null){
				this.osw.close();
			}
			if(this.out != null){
				this.out.close();
			}
			if(this.s != null){
				this.s.close();
			}
			
			this.isStarted = false;
			logger.log(Level.INFO, "ServerConnection", "closeConnection", "Connection with server closed !"); 
			
		} catch(IOException e) {
			logger.log(Level.SEVERE, "ServerConnection", "closeConnection", "IOException when closing connection:"+e);
		}
	
	}
	
	public void write(String message){
		
		CustomLogger logger = new CustomLogger();
		
		if(this.isStarted){
			try{
				
				bw.write(message); 
				bw.newLine();
				bw.flush();
				
				logger.log(Level.INFO, "ServerConnection", "write", "New message sent : "+message); 
				
			} catch (IOException e){
				this.closeConnection();
				Window window = Window.getInstance();
				window.dispose();
	            ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
	    		connexionwindow.setVisible(true);
	    		connexionwindow.setLocationRelativeTo(null);
				logger.log(Level.SEVERE, "ServerConnection", "write", "IOException when writing : "+e); 
			}
		} else {
			logger.log(Level.SEVERE, "ServerConnection", "write", "No connection to server"); 
		}
	}
	
	public String read(){
		
		CustomLogger logger = new CustomLogger();
		String message = null;
		
		if(this.isStarted){
			try{
				
				message = this.br.readLine();

			} catch (IOException e) {
				this.closeConnection();
				Window window = Window.getInstance();
				window.dispose();
	            ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
	    		connexionwindow.setVisible(true);
	    		connexionwindow.setLocationRelativeTo(null);
	    		logger.log(Level.SEVERE, "ServerConnection", "read", "IOException when writing : "+e);
			}

		} else {
			Window window = Window.getInstance();
			window.getChatTextArea().setText("Pas de connexion\n");
			logger.log(Level.SEVERE, "ServerConnection", "read", "No connection to server"); 
		}
		return message;
	}

}
