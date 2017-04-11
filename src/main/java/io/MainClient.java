package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClient {

	private static final Logger logger = Logger.getLogger(MainClient.class.getName());
	private static final int SERVER_PORT = 12345;
    private static final FileHandler fileHandler = null;
    private static final SimpleFormatter simpleFormatter = null;
    private static final String file = "./clientLogger.log";
	private static Socket s = null;
	private static OutputStream out = null;
	private static OutputStreamWriter osw = null;
	private static BufferedWriter bw =null;
	
	public MainClient(){
		//useless
	
	}
	
	public static void main(String[] args) throws ClientException{
		
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

		try {
			
//			simpleFormatter = new SimpleFormatter();
//			try {
//				fileHandler = new FileHandler(file, 0, 1, true);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	fileHandler.setFormatter(simpleFormatter);
//        	logger.addHandler(fileHandler);
//        	logger.setUseParentHandlers(false);
//        	logger.setLevel(java.util.logging.Level.FINEST);
        	
            //Appel première fenêtre de connexion
            ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    		connexionwindow.setVisible(true);
    		connexionwindow.setLocationRelativeTo(null);
    		logger.log(Level.INFO,"Window instanciated.");
    		
//    		while(true){
//    			try{
//    				
//    				s = new Socket(InetAddress.getByName(connexionwindow.getIpField()), SERVER_PORT);
//    				out = s.getOutputStream();
//    				osw = new OutputStreamWriter(out, "UTF-8");
//    				bw = new BufferedWriter(osw);
//    			
//    			} catch(IOException e){
//    				throw new ClientException("Error during message sending");
//    			} finally{
//    				try{
//    					
//    					if(bw != null)
//    						bw.close();
//    					if(osw != null)
//    						osw.close();
//    					if(out != null)
//    						out.close();
//    					if(s != null)
//    						s.close();
//    				}catch(IOException e){
//    					e.printStackTrace();
//    				}
//    			}
//    		}
    	
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "Security error in FileHandler :"+ e); 
		}
	}
}