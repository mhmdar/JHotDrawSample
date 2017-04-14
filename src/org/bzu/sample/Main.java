/**
 * 
 */
package org.bzu.sample;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.OSXApplication;
import org.jhotdraw.app.SDIApplication;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * The entry point of the simple drawing application which 
 * intends to use the design patterns reported by our team from jhotdraw.
 * <p/>
 * @author Mohammad Shawahneh
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//We are using the application editor provided by the jhotdraw.
		 ResourceBundleUtil.setVerbose(true);

	        Application app;
	        String os = System.getProperty("os.name").toLowerCase();
	        if (os.startsWith("mac")) {
	            app = new OSXApplication();
	        } else {
	            app = new SDIApplication();
	        } 
		
	        AppModel model = new AppModel();
	        model.setName("Learn Design Patterns");
	        model.setVersion(Main.class.getPackage().getImplementationVersion());
	        model.setCopyright("Design Patterns Project by Group D: Team Memebers:\n"
	        		+ "Mohammad Shawhaneh\nAhmad Zarour\nMohammad Tomaizy\n"
	        		+ "Nadeem Keelani\nSaad Hroub");
	        model.setViewClassName("org.bzu.sample.DrawingView");
	        
	        app.setModel(model);
	        app.launch(args);
	}

}
