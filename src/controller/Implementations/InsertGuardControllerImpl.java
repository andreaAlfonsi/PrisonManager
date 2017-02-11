package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import controller.Interfaces.InsertGuardController;
import model.Interfaces.Guard;
import view.Interfaces.InsertGuardView;
import view.Interfaces.SupervisorFunctionsView;

public class InsertGuardControllerImpl implements InsertGuardController{

	static InsertGuardView insertGuardView;
	
	public InsertGuardControllerImpl(InsertGuardView insertGuardView){
		InsertGuardControllerImpl.insertGuardView=insertGuardView;
		insertGuardView.addBackListener(new BackListener());
		insertGuardView.addInsertListener(new InsertListener());
	}
	
	public class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			insertGuardView.dispose();
			new SupervisorControllerImpl(new SupervisorFunctionsView(insertGuardView.getRank()));
		}
		
	}
	
	public void insertGuard(){
		List<Guard> guards = null;
		try {
			guards = LoginControllerImpl.getGuards();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		Guard g = insertGuardView.getGuard();
		boolean contains=false;
		for (Guard g1 : guards){
			if(g1.getID()==g.getID()){
				insertGuardView.displayErrorMessage("ID già usato");
				contains=true;
			}
		}
		if(isSomethingEmpty(g)){
			insertGuardView.displayErrorMessage("Completa tutti i campi correttamente");
			contains=true;
		}
		if(contains==false){
			guards.add(g);
			setGuards(guards);
			insertGuardView.displayErrorMessage("Guardia inserita");

		}
	}
	
	public class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			insertGuard();
		}
		
	}
	
	public boolean isSomethingEmpty(Guard g){
		if(g.getName().equals("")||g.getSurname().equals("")||g.getRank()<1||g.getRank()>3||g.getID()<0||g.getPassword().length()<6)
			return true;
		return false;
	}
	
	/**
	 * salva le guardie 
	 * @param guards lista di guardie
	 */
	public static void setGuards(List<Guard>guards){

		File f = new File("res/GuardieUserPass.txt");
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(fo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Guard g1 : guards){
			try {
				os.writeObject(g1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			os.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
