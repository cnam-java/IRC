package io;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClient {
<<<<<<< HEAD
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
=======
>>>>>>> ga_cr
	
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

<<<<<<< HEAD
		
		//Appel première fenêtre connexion
		ConnexionWindow connexionwindow = ConnexionWindow.getInstance();
		connexionwindow.setVisible(true);
		connexionwindow.setLocationRelativeTo(null);
		
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
=======
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
        	
            //Appel premiÃ¨re fenÃªtre de connexion
            ConnexionWindow window = new ConnexionWindow();
    		window.setVisible(true);
    		window.setLocationRelativeTo(null);
    		logger.log(Level.INFO,"Window instanciated.");
		
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "Security error in FileHandler :"+ e); 
		}
>>>>>>> ga_cr
	}
}