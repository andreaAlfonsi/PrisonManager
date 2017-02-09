package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import model.Interfaces.Prisoner;
import view.Components.PrisonManagerJFrame;
import view.Interfaces.ShowPrisonersView;
import view.Interfaces.SupervisorFunctionsView;

public class ShowPrisonersControllerImpl extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2056633481557914162L;
	
	static ShowPrisonersView showPrisonersView;
	
	public ShowPrisonersControllerImpl(ShowPrisonersView showPrisonersView){
		ShowPrisonersControllerImpl.showPrisonersView=showPrisonersView;
		ShowPrisonersControllerImpl.showPrisonersView.addBackListener(new BackListener());
		ShowPrisonersControllerImpl.showPrisonersView.addComputeListener(new ComputeListener());
	}

	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			showPrisonersView.dispose();
			new SupervisorControllerImpl(new SupervisorFunctionsView(showPrisonersView.getRank()));
		}
		
	}
	
	public static class ComputeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Date from=showPrisonersView.getFrom();
			Date to=showPrisonersView.getTo();
			List<Prisoner>list = null;
			List<Prisoner>inclusi = new ArrayList<>();
			try {
				list=MainControllerImpl.getPrisoners();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			for(Prisoner p : list){
				if(p.getInizio().before(to)&&p.getFine().after(from)){
					inclusi.add(p);
				}
			}
			JTable table = new JTable();
			String[]vet={"id","nome","cognome","giorno di nascita","inizio prigionia","fine prigionia"};
			String[][]mat=new String[list.size()][vet.length];
			for(int i=0;i<inclusi.size();i++){
				mat[i][0]=String.valueOf(inclusi.get(i).getIdPrigioniero());
				mat[i][1]=inclusi.get(i).getName();
				mat[i][2]=inclusi.get(i).getSurname();
				mat[i][3]=inclusi.get(i).getBirthDate().toString();
				mat[i][4]=inclusi.get(i).getInizio().toString();
				mat[i][5]=inclusi.get(i).getFine().toString();
			}
			table=new JTable(mat,vet);
			showPrisonersView.createTable(table);
		}
		
	}
}
