package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import model.Interfaces.Guard;
import view.Interfaces.SupervisorFunctionsView;
import view.Interfaces.ViewGuardView;

public class ViewGuardControllerImpl {

	static ViewGuardView viewGuardView;
	
	public ViewGuardControllerImpl(ViewGuardView viewGuardView){
		ViewGuardControllerImpl.viewGuardView=viewGuardView;
		viewGuardView.addBackListener(new BackListener());
		viewGuardView.addViewListener(new ViewGuardListener());
	}
	
	public static class ViewGuardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Guard>list = null;
			try {
				list=LoginControllerImpl.getGuards();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(Guard g : list){
				if(g.getID()==viewGuardView.getID()){
					viewGuardView.setName(g.getName());
					viewGuardView.setSurname(g.getSurname());
					viewGuardView.setBirth(g.getBirthDate().toString());
					viewGuardView.setRank(String.valueOf(g.getRank()));
					viewGuardView.setTelephone(g.getTelephoneNumber());
				}
			}
		}
		
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			viewGuardView.dispose();
			new SupervisorControllerImpl(new SupervisorFunctionsView(viewGuardView.getRank()));
		}
		
	}
}
