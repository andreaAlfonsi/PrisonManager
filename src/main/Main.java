package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Implementations.LoginControllerImpl;
import model.Implementations.GuardImpl;
import model.Interfaces.Guard;
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
		 File f = new File("res/GuardieUserPass.txt");
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			String pattern = "MM/dd/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    Date date = null;
			try {
				date = format.parse("12/31/2006");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Guard g1 = new GuardImpl("andrea","alfonsi",date,1,"68987809",1,"ciao");
			try {
				date = format.parse("12/31/1996");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Guard g2 = new GuardImpl("giuseppe", "mascara", date, 3,"234324",2,"asdasd");
			List<Guard> listGuardie = new ArrayList<>();
			listGuardie.add(g1);
			listGuardie.add(g2);
			for(Guard gua : listGuardie){
				oo.writeObject(gua);
			}
			oo.close();
			 new LoginControllerImpl(new LoginView());

	 }
	 
}
