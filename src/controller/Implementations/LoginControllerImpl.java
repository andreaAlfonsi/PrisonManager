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

import controller.Interfaces.LoginController;
import model.Interfaces.Guard;
import view.Interfaces.LoginView;
import view.Interfaces.MainView;

public class LoginControllerImpl implements LoginController{
	
	LoginView loginView;

	public LoginControllerImpl(LoginView loginView){
		this.loginView=loginView;
		loginView.addLoginListener(new LoginListener());
	}
	
	public class LoginListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			List<Guard> guards = null;
			try {
				guards = getGuards();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			boolean isInside=false;

			if(loginView.getUsername().isEmpty() || loginView.getPassword().isEmpty())
				loginView.displayErrorMessage("you must enter username and password");
			else{
			for (Guard g : guards){		
				if(loginView.getUsername().equals(String.valueOf(g.getUsername())) && loginView.getPassword().equals(g.getPassword())){
					isInside=true;
					loginView.displayErrorMessage("Benvenuto Utente "+ loginView.getUsername());	
					loginView.dispose();
					new MainControllerImpl(new MainView(g.getRank()));
				}
			}
			if(isInside==false){
				loginView.displayErrorMessage("username/password combination incorrect");
			}
			isInside = false;
		}
		}
		
	}
	
	public List<Guard> getGuards() throws IOException, ClassNotFoundException{
		File f = new File("res/GuardieUserPass.txt");
		FileInputStream fi = new FileInputStream(f);
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		List<Guard> guards = new ArrayList<>();
		
		try{
			while(true){
				Guard s = (Guard) oi.readObject();
				guards.add(s);
			}
		}catch(EOFException eofe){}
		
		fi.close();
		oi.close();
		
		return guards;
	}
}
