package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Interfaces.Prisoner;
import view.Interfaces.MainView;
import view.Interfaces.PrisonerProfileView;

public class ViewPrisonerControllerImpl {

	static PrisonerProfileView viewPrisonerView;
	
	public ViewPrisonerControllerImpl(PrisonerProfileView viewPrisonerView){
		ViewPrisonerControllerImpl.viewPrisonerView=viewPrisonerView;
		viewPrisonerView.addViewListener(new ViewProfileListener());
		viewPrisonerView.addBackListener(new BackListener());
	}
	
	public class ViewProfileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			boolean found=false;
			if(String.valueOf(viewPrisonerView.getID()).isEmpty()){
				viewPrisonerView.displayErrorMessage("you must enter an id");
			}
			List<Prisoner>prisoners=new ArrayList<>();
			 try {
				prisoners=MainControllerImpl.getPrisoners();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			 for(Prisoner p : prisoners){
				 if(p.getIdPrigioniero()==viewPrisonerView.getID()){
					 viewPrisonerView.setProfile(p.getName(), p.getSurname(), p.getBirthDate().toString(), p.getInizio().toString(), p.getFine().toString());
					 viewPrisonerView.setTextArea(p.getCrimini());
					 found=true;
				 }
			 }
			 if(!found){
					viewPrisonerView.displayErrorMessage("user not found");
			 }
		}
		
	}

	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			viewPrisonerView.dispose();
			new MainControllerImpl(new MainView(viewPrisonerView.getRank()));
		}
		
	}
}
