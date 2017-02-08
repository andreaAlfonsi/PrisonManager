package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import model.Implementations.MovementImpl;
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
			int balance=0;
			List<MovementImpl>list=AddMovementControllerImpl.InsertListener.getMovements();
			for(MovementImpl m:list){	
					switch(m.getChar()){
				case '-' : balance-=m.getAmount();
					break;
				case '+' : balance+=m.getAmount();
					break;
				}
			}
			balanceView.setLabel(String.valueOf(balance));
			String[]vet={"+ : -","amount","desc"};
			String[][]mat=new String[list.size()+1][vet.length];
			mat[0][0]=vet[0];
			mat[0][1]=vet[1];
			mat[0][2]=vet[2];
			for(int i=0;i<list.size();i++){
					mat[i+1][0]=String.valueOf(list.get(i).getChar());
					mat[i+1][1]=String.valueOf(list.get(i).getAmount());
					mat[i+1][2]=list.get(i).getDescr();
			}
			JTable table=new JTable(mat,vet);
			balanceView.createTable(table);
		}
		
	}
}
