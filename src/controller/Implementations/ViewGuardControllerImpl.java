package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
