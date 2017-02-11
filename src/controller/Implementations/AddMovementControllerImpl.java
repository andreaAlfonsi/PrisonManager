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
import java.util.List;

import model.Implementations.MovementImpl;
import view.Interfaces.AddMovementView;
import view.Interfaces.MoreFunctionsView;

public class AddMovementControllerImpl {

	static AddMovementView addMovementView;
	
	public AddMovementControllerImpl(AddMovementView addMovementView){
		AddMovementControllerImpl.addMovementView=addMovementView;
		AddMovementControllerImpl.addMovementView.addBackListener(new BackListener());
		AddMovementControllerImpl.addMovementView.addInsertListener(new InsertListener());
	}
	public class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addMovementView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(addMovementView.getRank()));
		}
		
	}
	
	public static class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MovementImpl m = new MovementImpl(addMovementView.getDesc(),addMovementView.getValue(),addMovementView.getSymbol().charAt(0));
			if(m.getAmount()<=0){
				addMovementView.displayErrorMessage("Input invalido");
				return;
			}
			List<MovementImpl> movements = getMovements();
			movements.add(m);
			try {
				setMovements(movements);
			} catch (IOException e) {
				e.printStackTrace();
			}
			addMovementView.displayErrorMessage("Movimento inserito");
		}
		
		/**
		 * ritorna la lista dei movimenti di bilancio
		 * @return lista dei movimenti
		 */
		public static List<MovementImpl> getMovements(){
			File f = new File("res/AllMovements.txt");
			if(f.length()==0){
				List<MovementImpl>list=new ArrayList<>();
				return list;
			}
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
			List<MovementImpl> list2 = new ArrayList<>();
			try{
				while(true){
					MovementImpl s = (MovementImpl) is.readObject();
					list2.add(s);
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
			return list2;
		}
		
		/**
		 * salva la lista aggiornata di movimenti
		 * @param list lista dei movimenti
		 * @throws IOException
		 */
		public void setMovements(List<MovementImpl> list) throws IOException{
			File f = new File("res/AllMovements.txt");
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.flush();
			fo.flush();
			for(MovementImpl s : list){
				os.writeObject(s);
			}
			os.close();
		}
	}
	
}
	
	
	

