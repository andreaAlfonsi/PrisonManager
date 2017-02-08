package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import model.Interfaces.Prisoner;
import view.Interfaces.Chart2View;
import view.Interfaces.MoreFunctionsView;

public class Chart2ControllerImpl {

	static Chart2View chart2View;
	
	public Chart2ControllerImpl(Chart2View chart2View){
		
		Chart2ControllerImpl.chart2View=chart2View;
		chart2View.addBackListener(new BackListener());
		chart2View.addComputeListener(new ComputeListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chart2View.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(chart2View.getRank()));
		}
		
	}
	
	public static class ComputeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				List<Prisoner> list = MainControllerImpl.getCurrentPrisoners();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
