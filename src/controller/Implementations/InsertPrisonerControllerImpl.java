package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Implementations.PrisonerImpl;
import model.Interfaces.Prisoner;
import view.Interfaces.InsertPrisonerView;
import view.Interfaces.MainView;

public class InsertPrisonerControllerImpl {

	InsertPrisonerView insertPrisonerView;
	
	public InsertPrisonerControllerImpl(InsertPrisonerView insertPrisonerView) {
		this.insertPrisonerView=insertPrisonerView;
		insertPrisonerView.addInsertPrisonerListener(new InsertPrisonerListener());
		insertPrisonerView.addBackListener(new BackListener());
	}
	
	public class InsertPrisonerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			 List<Prisoner>prisoners=new ArrayList<>();
			 try {
				prisoners=MainControllerImpl.getPrisoners();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
				Prisoner p = new PrisonerImpl(insertPrisonerView.getName1(), insertPrisonerView.getSurname1(), insertPrisonerView.getBirth1(), insertPrisonerView.getPrisonerID1(), insertPrisonerView.getStart1(), insertPrisonerView.getEnd1());
				if(isSomethingEmpty(p)){
					insertPrisonerView.displayErrorMessage("complete all the fields");
				}
				else{
					for(Prisoner p1 : prisoners){
						if(p1.getIdPrigioniero()==p.getIdPrigioniero()){
							insertPrisonerView.displayErrorMessage("id already used");
						}
					}
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR_OF_DAY, 0); //
					if(p.getInizio().after(p.getFine())||p.getInizio().before(today.getTime())){
						insertPrisonerView.displayErrorMessage("dates can't be correct");
					}
					else{
						prisoners.add(p);
						File f = new File("res/prisoners.txt");
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
						for(Prisoner s : prisoners){
							try {
								os.writeObject(s);
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
		}
		
	}
	
	public class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			insertPrisonerView.dispose();
			new MainControllerImpl(new MainView());
		}
		
	}
	
	public boolean isSomethingEmpty(Prisoner p){
		if(p.getName().isEmpty()||p.getSurname().isEmpty()){
			return true;
		}
		return false;
	}
}
