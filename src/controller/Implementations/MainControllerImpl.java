package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import model.Interfaces.Prisoner;
import view.Interfaces.InsertPrisonerView;
import view.Interfaces.LoginView;
import view.Interfaces.MainView;

public class MainControllerImpl {

	MainView mainView;
	public MainControllerImpl(MainView mainView){
		this.mainView=mainView;
		mainView.addLogoutListener(new LogoutListener());
		mainView.addInsertPrisonerListener(new InsertPrisonerListener());
	}
		
	public class LogoutListener implements ActionListener{
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainView.dispose();
			new LoginControllerImpl(new LoginView());
			 
		}
	}
	
	public class InsertPrisonerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainView.dispose();
			new InsertPrisonerControllerImpl(new InsertPrisonerView());
		}
	}
	public class removePrisonerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			 
		}
	}
	
	public class viewPrisonerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			 
		}
	}
	
	public static List<Prisoner> getPrisoners() throws IOException, ClassNotFoundException{
		File f = new File("res/Prisoners.txt");
		List<Prisoner> prisoners = new ArrayList<>();
		if(f.length()!=0){
		FileInputStream fi = new FileInputStream(f);
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		
		try{
			while(true){
				Prisoner s = (Prisoner) oi.readObject();
				prisoners.add(s);
			}
		}catch(EOFException eofe){}
		
		fi.close();
		oi.close();
		}
		return prisoners;
	}

}
