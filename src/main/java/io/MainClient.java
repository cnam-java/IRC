package io;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClient {
	
	public static final Logger logger = Logger.getLogger(MainClient.class.getName());

    private static FileHandler fileHandler = null;
    private static SimpleFormatter simpleFormatter = null;
    private static final String file = "./clientLogger.log";
    
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
            ConnexionWindow window = new ConnexionWindow();
    		window.setVisible(true);
    		window.setLocationRelativeTo(null);
    		logger.log(Level.INFO,"Window instanciated.");
		
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "Security error in FileHandler :"+ e); 
		}
	}
}