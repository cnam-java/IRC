package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MainClient {
	private static final Logger LOG = Logger.getLogger(MainClient.class.getName());
	private static final String NICKNAME = "Andrea";
	private static final int SERVER_PORT = 12345;
	private static final String SERVER_HOST = "10.42.0.1";
	
	
	public static void runClient() throws ClientException{
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
		Window window = new Window();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
	}

}
