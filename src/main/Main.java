package main;

import java.io.IOException;
import controller.Implementations.LoginControllerImpl;
import view.Interfaces.LoginView;

/**
 * The main of the application.
 */
public final class Main {
	
	/**
     * Program main, this is the "root" of the application.
     * @param args
     * unused,ignore
	 * @throws IOException 
     */
	 public static void main(final String... args) throws IOException {
			 new LoginControllerImpl(new LoginView());
	 }
	 
}
