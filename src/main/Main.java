package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.Implementations.LoginControllerImpl;
import model.Implementations.CellImpl;
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
	 * @throws ClassNotFoundException 
     */
	 public static void main(final String... args) throws IOException, ClassNotFoundException {
		 
		 File f = new File("res/Celle.txt");
		 if(f.length()<3){
		 List<CellImpl>list=new ArrayList<>();
		 CellImpl c;
		 for(int i=0;i<50;i++){
			 if(i<20){
				  c = new CellImpl(i, "Primo piano", 4);
			 }
			 else
				 if(i<40){
					  c = new CellImpl(i, "Secondo piano", 3);
				 }
				 else
					 if(i<45){
					  c = new CellImpl(i, "Terzo piano", 4);
				 }
					 else{
						  c = new CellImpl(i, "Seminterrato, celle di isolamento", 1);
					 }
			 list.add(c);
		 }
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.flush();
			fo.flush();
			for(CellImpl s : list){
				os.writeObject(s);
			}
			os.close();
		 }
		 
		 new LoginControllerImpl(new LoginView());
	 }
	 
}
