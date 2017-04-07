package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClient {
	private static final Logger LOG = Logger.getLogger(MainClient.class.getName());
	
	public MainClient(){
		//useless
	
	}
	
	public static void main(String[] args){
		
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
			ConsoleHandler console = new ConsoleHandler();
			FileHandler fh = new FileHandler("./clientLogger.log", true);
			SimpleFormatter sf = new SimpleFormatter();
		
			LOG.addHandler(console); 
			LOG.addHandler(fh);
			fh.setFormatter(sf);
            LOG.setLevel(Level.ALL);
            
            LOG.log(Level.CONFIG, "Configuration done.");
            LOG.removeHandler(console);
            
            //Appel première fenêtre de connexion
            ConnexionWindow window = new ConnexionWindow();
    		window.setVisible(true);
    		window.setLocationRelativeTo(null);
		
		} catch (SecurityException e) {
			LOG.log(Level.SEVERE, "Security error in FileHandler.", e); 
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "An error occured in FileHandler.", e);
		}
	}
}