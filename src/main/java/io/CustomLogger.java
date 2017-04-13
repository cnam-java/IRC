package io;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger{
	
    private static Logger logger = Logger.getLogger(CustomLogger.class.getName());
    private static FileHandler fileHandler = null;
    private static SimpleFormatter simpleFormatter = null;
    private static final String file = "./clientLogger.log";
   
    
    public CustomLogger(){
    	
    }
    
    public void initLogger(){

        try {
        		simpleFormatter = new SimpleFormatter();
				fileHandler = new FileHandler(file, true);
            	fileHandler.setFormatter(simpleFormatter);
            	logger.addHandler(fileHandler);
            	logger.setUseParentHandlers(false);
            	logger.setLevel(java.util.logging.Level.FINEST);

    		} catch (SecurityException e) {
    			logger.log(java.util.logging.Level.SEVERE, "Security Exception for logger : "+e);
    		} catch (IOException e) {
    			logger.log(java.util.logging.Level.SEVERE,"IOException for logger : "+e);
    		}
        
    }

    
    public void log(Level level, String className, String method, String message){
  	
        logger.logp(level, className, method, message);
        
    }  
}