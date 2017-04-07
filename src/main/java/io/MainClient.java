package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MainClient {
	private static final Logger LOG = Logger.getLogger(MainClient.class.getName());
	private static final int SERVER_PORT = 12345;
	
	
	public static void runClient(String SERVER_HOST,String NICKNAME) throws ClientException{
		Scanner sc = null;
		Socket s = null;
		
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw =null;
		
		
		//PrintWriter pw = null;
		
		LOG.info("init Client");
		
		sc = new Scanner(System.in);
		while(true){
			try{
				
				
				
				final String msg = sc.nextLine();
				
				s = new Socket(InetAddress.getByName(SERVER_HOST), SERVER_PORT);
				out = s.getOutputStream();
				osw = new OutputStreamWriter(out, "UTF-8");
				bw = new BufferedWriter(osw);
				
				bw.write(NICKNAME + " : "+ msg);
				bw.flush();
				
			} catch(IOException e){
				throw new ClientException("Error during message sending");
			} finally{
				try{
					
					if(bw != null)
						bw.close();
					if(osw != null)
						osw.close();
					if(out != null)
						out.close();
					if(s != null)
						s.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public MainClient(){
		//useless
	
	}
	
	public static void main(String[] args){
//		PropertyConfigurator.configure("log4j.properties");
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		//Appel première fenêtre connexion
		ConnexionWindow window = ConnexionWindow.getInstance();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
//		  Window window = new Window();
//		  window.setVisible(true);
//		  window.setLocationRelativeTo(null);
		
//		try{
//		MainClient.runClient();
//		System.exit(0);
//		}catch(ClientException e){
//			LOG.error("Error in client management");
//			
//		}
	}

}