package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Interfaces.InsertGuardView;
import view.Interfaces.MainView;
import view.Interfaces.RemoveGuardView;
import view.Interfaces.ShowPrisonersView;
import view.Interfaces.SupervisorFunctionsView;
import view.Interfaces.ViewGuardView;

public class SupervisorControllerImpl {

	static SupervisorFunctionsView supervisorFunctionsView;
	
	public SupervisorControllerImpl(SupervisorFunctionsView supervisorFunctionsView){
		SupervisorControllerImpl.supervisorFunctionsView=supervisorFunctionsView;
		supervisorFunctionsView.addBackListener(new BackListener());
		supervisorFunctionsView.addShowPrisonersListener(new ShowPrisonersListener());
		supervisorFunctionsView.addInsertGuardListener(new InsertGuardListener());
		supervisorFunctionsView.addRemoveGuardListener(new RemoveGuardListener());
		supervisorFunctionsView.addviewGuardListener(new ViewGuardListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			supervisorFunctionsView.dispose();
			new MainControllerImpl(new MainView(supervisorFunctionsView.getRank()));
		}
		
	}
	
	public static class InsertGuardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			supervisorFunctionsView.dispose();
			new InsertGuardControllerImpl(new InsertGuardView(supervisorFunctionsView.getRank()));
		}
		
	}
	
	public static class RemoveGuardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			supervisorFunctionsView.dispose();
			new RemoveGuardControllerImpl(new RemoveGuardView(supervisorFunctionsView.getRank()));
		}
		
	}
	
	public static class ShowPrisonersListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			supervisorFunctionsView.dispose();
			new ShowPrisonersControllerImpl(new ShowPrisonersView(supervisorFunctionsView.getRank()));
		}
		
	}
	
	public static class ViewGuardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			supervisorFunctionsView.dispose();
			new ViewGuardControllerImpl(new ViewGuardView(supervisorFunctionsView.getRank()));
		}
		
	}
}
