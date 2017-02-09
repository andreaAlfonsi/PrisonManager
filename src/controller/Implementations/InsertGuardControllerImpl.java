package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import model.Interfaces.Guard;
import view.Interfaces.InsertGuardView;
import view.Interfaces.SupervisorFunctionsView;

public class InsertGuardControllerImpl {

	static InsertGuardView insertGuardView;
	
	public InsertGuardControllerImpl(InsertGuardView insertGuardView){
		InsertGuardControllerImpl.insertGuardView=insertGuardView;
		insertGuardView.addBackListener(new BackListener());
		insertGuardView.addInsertListener(new InsertListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			insertGuardView.dispose();
			new SupervisorControllerImpl(new SupervisorFunctionsView(insertGuardView.getRank()));
		}
		
	}
	
	public static class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			List<Guard> guards = null;
			try {
				guards = LoginControllerImpl.getGuards();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			Guard g = insertGuardView.getGuard();
			System.out.println(g.toString());
			boolean contains=false;
			for (Guard g1 : guards){
				if(g1.getID()==g.getID()){
					System.out.println("error");
					contains=true;
				}
			}
			if(contains==false){
				guards.add(g);
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
				System.out.println(guards.toString());

			}
		}
		
	}
}
