package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Interfaces.AddMovementView;
import view.Interfaces.BalanceView;
import view.Interfaces.Chart1View;
import view.Interfaces.Chart2View;
import view.Interfaces.MainView;
import view.Interfaces.MoreFunctionsView;

public class MoreFunctionsControllerImpl {

	static MoreFunctionsView moreFunctionsView;
	
	public MoreFunctionsControllerImpl(MoreFunctionsView moreFunctionsView){
		MoreFunctionsControllerImpl.moreFunctionsView=moreFunctionsView;
		moreFunctionsView.addBackListener(new BackListener());
		moreFunctionsView.addAddMovementListener(new AddMovementListener());
		moreFunctionsView.addBalanceListener(new BalanceListener());
		moreFunctionsView.addChart1Listener(new Chart1Listener());
		moreFunctionsView.addChart2Listener(new Chart2Listener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			moreFunctionsView.dispose();
			new MainControllerImpl(new MainView(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class AddMovementListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			moreFunctionsView.dispose();
			new AddMovementControllerImpl(new AddMovementView(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class BalanceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new BalanceControllerImpl(new BalanceView(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class Chart1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new Chart1ControllerImpl(new Chart1View(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class Chart2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new Chart2ControllerImpl(new Chart2View(moreFunctionsView.getRank()));
		}
		
	}
}
