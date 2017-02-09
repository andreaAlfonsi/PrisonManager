package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Interfaces.Prisoner;
import view.Components.PieChart_AWT;
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
			String[] crimes = {"Reati contro gli animali","Reati associativi","Blasfemia e sacrilegio","Reati economici e finanziari","Falsa testimonianza","Reati militari","Reati contro il patrimonio","Reati contro la persona","Reati nell' ordinamento italiano","Reati tributari","Traffico di droga","Casi di truffe"};
			 ArrayList<String>crimesList = new ArrayList<>(Arrays.asList(crimes));
			List<Prisoner> list = null;
			try {
				list = MainControllerImpl.getCurrentPrisoners();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			
			Map<String,Integer>map=new HashMap<>();
			for(String s : crimesList){
				map.put(s, 0);
			}
			for(Prisoner p: list){
				for(String s : p.getCrimini()){
					if(crimesList.contains(s)){
						map.put(s, map.get(s)+1);
					}
				}
			}
			@SuppressWarnings("unused")
			PieChart_AWT pie = new PieChart_AWT("Percentuale crimini",map);
		}
	}
}
