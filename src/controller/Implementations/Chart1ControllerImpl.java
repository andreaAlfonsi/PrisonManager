package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Interfaces.Prisoner;
import view.Components.BarChart_AWT;
import view.Interfaces.Chart1View;
import view.Interfaces.MoreFunctionsView;

public class Chart1ControllerImpl {

	static Chart1View chart1View;
	
	public Chart1ControllerImpl(Chart1View chart1View){
		
		Chart1ControllerImpl.chart1View=chart1View;
		chart1View.addBackListener(new BackListener());
		chart1View.addComputeListener(new ComputeListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			chart1View.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(chart1View.getRank()));
		}
		
	}
	
	public static class ComputeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Map<Integer,Integer>map=new TreeMap<>();
			final int opening=2010;
			List<Prisoner> list = null;
			try {
				list = MainControllerImpl.getPrisoners();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			int max=getMax(list);
			for(int i=opening;i<max;i++){
				int num = 0;;
				for(Prisoner p:list){
					if(p.getInizio().getYear()+1900<=i&&p.getFine().getYear()+1900>=i){
						num++;
					}		
				}
				map.put(i, num);
			}
			BarChart_AWT chart = new BarChart_AWT(map,"Number of prisoners chart","Chart");
			
			
		}
		public int getMax(List<Prisoner>list){
			int max=0;
			for(Prisoner p: list){
				if(p.getFine().getYear()>max){
					max=p.getFine().getYear();
				}
			}
			return max+1900;
		}
	}
	
}
