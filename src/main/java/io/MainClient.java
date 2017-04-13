package io;

import java.util.logging.Level;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClient {

	
	public MainClient(){
		//useless
	
	}
	
	public static void main(String[] args) {
		
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

			CustomLogger logger = new CustomLogger();
			logger.initLogger();
			
            //Appel première fenêtre de connexion
            ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
    		connexionwindow.setVisible(true);
    		connexionwindow.setLocationRelativeTo(null);
    		logger.log(Level.INFO,"MainClient","main","ConnexionWindow instanciated and launched.");
    		
	}
}