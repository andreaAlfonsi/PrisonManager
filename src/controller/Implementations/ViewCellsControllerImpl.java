package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import controller.Interfaces.ViewCellsController;
import model.Implementations.CellImpl;
import view.Interfaces.MoreFunctionsView;
import view.Interfaces.ViewCellsView;

public class ViewCellsControllerImpl implements ViewCellsController{

	static ViewCellsView viewCellsView;
	
	public ViewCellsControllerImpl( ViewCellsView viewCellsView){
		ViewCellsControllerImpl.viewCellsView=viewCellsView;
		viewCellsView.addBackListener(new BackListener());
		viewCellsView.createTable(getTable());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			viewCellsView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(viewCellsView.getRank()));
		}
		
	}
	
	public JTable getTable(){
		List<CellImpl>list=null;
		list=InsertPrisonerControllerImpl.getCells();
		
		String[]vet={"ID Cella","Descrizione","Prigionieri correnti","Capacità max"};
		String[][]mat=new String[list.size()][vet.length];
		for(int i=0;i<list.size();i++){
			mat[i][0]=String.valueOf(list.get(i).getId());
			mat[i][1]=list.get(i).getPosition();
			mat[i][2]=String.valueOf(list.get(i).getCurrentPrisoners());
			mat[i][3]=String.valueOf(list.get(i).getCapacity());
		}
		JTable table=new JTable(mat,vet);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		return table;
	}
}
