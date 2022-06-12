package Module3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
//import java.util.logging.Filter;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {

	static Logger logger = Logger.getLogger(Logging.class.getName());
	
	public static void main(String[] args) throws SecurityException, IOException {
		try { 
			LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
		} catch (SecurityException | IOException e1) {
			e1.printStackTrace();
		}
		logger.setLevel(Level.FINE);
		logger.addHandler(new ConsoleHandler());
		//adding custom handler
		logger.addHandler(new FileHandler());
		try {
			//FileHandler file name with max size and number of log files limit
			Handler fileHandler = new FileHandler("C:\\Users\\Lo\\Desktop\\Advanced Java Programming\\logger.log", 2000, 5);
			fileHandler.setFormatter(new SimpleFormatter());
			//setting custom filter for FileHandler
			//fileHandler.setFilter(new Filter());
			logger.addHandler(fileHandler);
			
			for(int i=0; i<1000; i++) {
				//logging messages
				logger.log(Level.INFO, "MSG"+i);
			}
			logger.log(Level.CONFIG, "Config data");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
 

