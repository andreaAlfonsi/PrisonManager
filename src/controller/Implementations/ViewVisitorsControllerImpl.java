package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;

import model.Interfaces.Visitor;
import view.Interfaces.MoreFunctionsView;
import view.Interfaces.ViewVisitorsView;

public class ViewVisitorsControllerImpl {

	static ViewVisitorsView viewVisitorsView;
	
	public ViewVisitorsControllerImpl(ViewVisitorsView viewVisitorsView){
		ViewVisitorsControllerImpl.viewVisitorsView=viewVisitorsView;
		viewVisitorsView.addBackListener(new BackListener());
		viewVisitorsView.createTable(getTable());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			viewVisitorsView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(viewVisitorsView.getRank()));
		}
		
	}
	
	public JTable getTable(){
		List<Visitor>list=null;
		try {
			list=AddVisitorsControllerImpl.InsertListener.getVisitor();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		String[]vet={"Name","Surname","BirthDate","Prisoner Visited ID"};
		String[][]mat=new String[list.size()+1][vet.length];
		for(int i=0;i<list.size();i++){
			mat[i][0]=list.get(i).getName();
			mat[i][1]=list.get(i).getSurname();
			mat[i][2]=list.get(i).getBirthDate().toString();
			mat[i][3]=String.valueOf(list.get(i).getIdPrisoner());
		}
		JTable table=new JTable(mat,vet);
		return table;
	}
	
}
