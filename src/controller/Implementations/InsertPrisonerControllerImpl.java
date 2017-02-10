package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Implementations.CellImpl;
import model.Implementations.PrisonerImpl;
import model.Interfaces.Prisoner;
import view.Interfaces.InsertPrisonerView;
import view.Interfaces.MainView;

public class InsertPrisonerControllerImpl {

	static InsertPrisonerView insertPrisonerView;
	
	public InsertPrisonerControllerImpl(InsertPrisonerView insertPrisonerView) {
		InsertPrisonerControllerImpl.insertPrisonerView=insertPrisonerView;
		insertPrisonerView.addInsertPrisonerListener(new InsertPrisonerListener());
		insertPrisonerView.addBackListener(new BackListener());
		insertPrisonerView.addAddCrimeListener(new AddCrimeListener());
		
	}
	
	public class InsertPrisonerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean correct=true;
			 List<Prisoner>prisoners=new ArrayList<>();
			 List<Prisoner>currentPrisoners=new ArrayList<>();
			 try {
				prisoners=MainControllerImpl.getPrisoners();
				currentPrisoners=MainControllerImpl.getCurrentPrisoners();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

				Prisoner p = new PrisonerImpl(insertPrisonerView.getName1(), insertPrisonerView.getSurname1(), insertPrisonerView.getBirth1(), insertPrisonerView.getPrisonerID1(), insertPrisonerView.getStart1(), insertPrisonerView.getEnd1(),insertPrisonerView.getList(),insertPrisonerView.getCellID());
				if(isSomethingEmpty(p)){
					insertPrisonerView.displayErrorMessage("complete all the fields");
				}
				else{
					for(Prisoner p1 : prisoners){
						if(p1.getIdPrigioniero()==p.getIdPrigioniero()){
							insertPrisonerView.displayErrorMessage("id already used");
							correct=false;
						}
					}
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR_OF_DAY, 0); //
					if(correct==true){
					if(p.getInizio().after(p.getFine())||p.getInizio().before(today.getTime())){
						insertPrisonerView.displayErrorMessage("dates can't be correct");
					}
					else{
						prisoners.add(p);
						currentPrisoners.add(p);
						List<CellImpl>list=getCells();
						for(CellImpl c : list){
							if(p.getCellID()==c.getId())
								c.setCurrentPrisoners(c.getCurrentPrisoners()+1);
						}
						try {
							setCells(list);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						insertPrisonerView.displayErrorMessage("User Inserted");
						insertPrisonerView.setList(new ArrayList<String>());
						File f = new File("res/prisoners.txt");
						File f2 = new File("res/CurrentPrisoners.txt");
						FileOutputStream fo = null;
						FileOutputStream fo2 = null;
						try {
							fo = new FileOutputStream(f);
							fo2 = new FileOutputStream(f2);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						ObjectOutputStream os = null;
						ObjectOutputStream os2 = null;
						try {
							os = new ObjectOutputStream(fo);
							os2 = new ObjectOutputStream(fo2);
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
						for(Prisoner s : currentPrisoners){
							try {
								os2.writeObject(s);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						try {
							os.close();
							os2.close();
							fo.close();
							fo2.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					}
				}
		}
		
	}
	

	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			insertPrisonerView.dispose();
			new MainControllerImpl(new MainView(insertPrisonerView.getRank()));
		}
		
	}
	
	public static class AddCrimeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<String>list=insertPrisonerView.getList();
			if(list.contains(insertPrisonerView.getCombo())){
				insertPrisonerView.displayErrorMessage("crime already inserted");
			}
			else{
				list.add(insertPrisonerView.getCombo());
				insertPrisonerView.setList(list);
			}
		}
		
	}
	
	public boolean isSomethingEmpty(Prisoner p){
		if(p.getName().isEmpty()||p.getSurname().isEmpty()){
			return true;
		}
		return false;
	}
	
	public static List<CellImpl> getCells(){
		File f = new File("res/Celle.txt");
		List<CellImpl>list=new ArrayList<>();
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			while(true){
				CellImpl s = (CellImpl) is.readObject();
				list.add(s);
			}
			
		}catch(EOFException eofe){} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void setCells(List<CellImpl> list) throws IOException{
		File f = new File("res/Celle.txt");
		FileOutputStream fo = new FileOutputStream(f);
		ObjectOutputStream os = new ObjectOutputStream(fo);
		os.flush();
		fo.flush();
		for(CellImpl c : list){
			os.writeObject(c);
		}
		os.close();
		System.out.println(list.toString());
	}
}
