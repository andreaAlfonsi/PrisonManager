package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import model.Interfaces.Prisoner;
import view.Components.BarChart_AWT;
import view.Components.PieChart_AWT;
import view.Interfaces.AddMovementView;
import view.Interfaces.AddVisitorsView;
import view.Interfaces.BalanceView;
import view.Interfaces.MainView;
import view.Interfaces.MoreFunctionsView;
import view.Interfaces.ViewCellsView;
import view.Interfaces.ViewVisitorsView;

public class MoreFunctionsControllerImpl {

	static MoreFunctionsView moreFunctionsView;
	
	public MoreFunctionsControllerImpl(MoreFunctionsView moreFunctionsView){
		MoreFunctionsControllerImpl.moreFunctionsView=moreFunctionsView;
		moreFunctionsView.addBackListener(new BackListener());
		moreFunctionsView.addAddMovementListener(new AddMovementListener());
		moreFunctionsView.addBalanceListener(new BalanceListener());
		moreFunctionsView.addChart1Listener(new Chart1Listener());
		moreFunctionsView.addChart2Listener(new Chart2Listener());
		moreFunctionsView.addAddVisitorsListener(new AddVisitorsListener());
		moreFunctionsView.addViewVisitorsListener(new ViewVisitorsListener());
		moreFunctionsView.addViewCellsListener(new ViewCellsListener());
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

			Map<Integer,Integer>map=new TreeMap<>();
			final int opening=2017;
			List<Prisoner> list = null;
			try {
				list = MainControllerImpl.getPrisoners();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			int max=getMax(list);
			for(int i=opening;i<=max;i++){
				int num = 0;;
				for(Prisoner p:list){
					Calendar calendar = Calendar.getInstance();
					Calendar calendar2 = Calendar.getInstance();
					calendar.setTime(p.getInizio());
					calendar2.setTime(p.getFine());
					if(calendar.get(Calendar.YEAR)<=i&&calendar.get(Calendar.YEAR)>=i){
						num++;
					}		
				}
				map.put(i, num);
			}
			BarChart_AWT chart = new BarChart_AWT(map,"Number of prisoners chart","Chart");
			chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
		}
		public int getMax(List<Prisoner>list){
			int max=0;
			for(Prisoner p: list){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(p.getFine());
				if(calendar.get(Calendar.YEAR)>max){
					max=calendar.get(Calendar.YEAR);
				}
			}
			return max;
		}
	}
	
	public static class Chart2Listener implements ActionListener{

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
			PieChart_AWT pie = new PieChart_AWT("Percentuale crimini",map);
			pie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
	}
	
	public static class AddVisitorsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new AddVisitorsControllerImpl(new AddVisitorsView(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class ViewVisitorsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new ViewVisitorsControllerImpl(new ViewVisitorsView(moreFunctionsView.getRank()));
		}
		
	}
	
	public static class ViewCellsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			moreFunctionsView.dispose();
			new ViewCellsControllerImpl(new ViewCellsView(moreFunctionsView.getRank()));
		}
		
	}
}
