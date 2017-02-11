package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.Interfaces.RemoveGuardController;
import model.Interfaces.Guard;
import view.Interfaces.RemoveGuardView;
import view.Interfaces.SupervisorFunctionsView;

public class RemoveGuardControllerImpl implements RemoveGuardController{

	static RemoveGuardView removeGuardView;
	
	public RemoveGuardControllerImpl(RemoveGuardView removeGuardView){
		RemoveGuardControllerImpl.removeGuardView=removeGuardView;
		removeGuardView.addBackListener(new BackListener());
		removeGuardView.addRemoveGuardListener(new RemoveGuardListener());
	}
	
	public class RemoveGuardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			removeGuard();
		}
		
	
	}
	
	public void removeGuard(){

		boolean found=false;
		List<Guard> guards= new ArrayList<>();
		try {
			guards=LoginControllerImpl.getGuards();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		for(Guard g : guards){
			if(g.getID()==removeGuardView.getID()){
				guards.remove(g);
				removeGuardView.displayErrorMessage("Guardia rimossa");
				found=true;
				break;
			}
		}
		
		File f = new File("res/GuardieUserPass.txt");
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(fo);
			os.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(Guard g : guards){
			try {
				os.writeObject(g);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			os.close();
			fo.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(!found){
			removeGuardView.displayErrorMessage("Guardia non trovata");
		}
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			removeGuardView.dispose();
			new SupervisorControllerImpl(new SupervisorFunctionsView(removeGuardView.getRank()));
		}
		
	}
}
