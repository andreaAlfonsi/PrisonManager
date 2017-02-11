package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import controller.Interfaces.BalanceController;
import model.Implementations.MovementImpl;
import view.Interfaces.BalanceView;
import view.Interfaces.MoreFunctionsView;

public class BalanceControllerImpl implements BalanceController{

	static BalanceView balanceView;
	
	public BalanceControllerImpl(BalanceView balanceView){
		BalanceControllerImpl.balanceView=balanceView;
		balanceView.addBackListener(new BackListener());
		showBalance();
	}
	
	public class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			balanceView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(balanceView.getRank()));
		}
		
	}
	
	public void showBalance(){
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
		String[]vet={"+ : -","amount","desc","data"};
		String[][]mat=new String[list.size()][vet.length];
		for(int i=0;i<list.size();i++){
				mat[i][0]=String.valueOf(list.get(i).getChar());
				mat[i][1]=String.valueOf(list.get(i).getAmount());
				mat[i][2]=list.get(i).getDescr();
				mat[i][3]=list.get(i).getData1().toString();
		}
		JTable table=new JTable(mat,vet);
		balanceView.createTable(table);
		
	}
}
