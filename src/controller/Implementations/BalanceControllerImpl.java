package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Interfaces.BalanceView;
import view.Interfaces.MoreFunctionsView;

public class BalanceControllerImpl {

	static BalanceView balanceView;
	
	public BalanceControllerImpl(BalanceView balanceView){
		BalanceControllerImpl.balanceView=balanceView;
		balanceView.addBackListener(new BackListener());
		balanceView.addComputeListener(new ComputeListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			balanceView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(balanceView.getRank()));
		}
		
	}
	
	public static class ComputeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
}
