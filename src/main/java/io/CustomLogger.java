package io;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger{
	
    private static Logger logger;
    private static FileHandler fileHandler = null;
    private static SimpleFormatter simpleFormatter = null;
    private static final String file = "./clientLogger.log";
    
    private static CustomLogger INSTANCE = new CustomLogger();

    public static CustomLogger getInstance(){
		return INSTANCE;
    }
    
    
    public void setName(String name){
    	logger = Logger.getLogger(name);
    }
     
    public void log(Level level, String message){
    	
        try {
        	//if( fileHandler == null){
        		simpleFormatter = new SimpleFormatter();
				fileHandler = new FileHandler(file, 0, 1, false);
            	fileHandler.setFormatter(simpleFormatter);
            	logger.addHandler(fileHandler);
        	//}
            logger.setUseParentHandlers(false);
            logger.setLevel(java.util.logging.Level.FINEST);
            logger.log(level, message);      
            
		} catch (SecurityException e) {
			//logger.log(java.util.logging.Level.SEVERE, "Security Exception for logger : "+e);
		} catch (IOException e) {
			//logger.log(java.util.logging.Level.SEVERE,"IOException for logger : "+e);
		}
    }  
}