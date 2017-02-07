package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import controller.Implementations.MoreFunctionsControllerImpl.AddMovementListener;
import controller.Implementations.MoreFunctionsControllerImpl.BackListener;
import controller.Implementations.MoreFunctionsControllerImpl.BalanceListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class MoreFunctionsView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -960406183837784254L;

	final PrisonManagerJPanel north;
	final JLabel title=new JLabel("More Functions");
	final PrisonManagerJPanel center;
	final JButton addMovement=new JButton("add a movement");
	final JButton viewBalance=new JButton("view Balance");
	final JButton viewFirstChart=new JButton("view first chart");
	final JButton viewSecondChart=new JButton("view second chart");
	final PrisonManagerJPanel south;
	final JButton back=new JButton("back");
	private int rank;
	
	public MoreFunctionsView(int rank){
		this.rank=rank;
		this.setSize(450, 300);
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
		center.add(addMovement);
		center.add(viewBalance);
		center.add(viewFirstChart);
		center.add(viewSecondChart);
		SpringUtilities.makeCompactGrid(center,
                2, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		this.getContentPane().add(BorderLayout.CENTER,center);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(back);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		this.setVisible(true);
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}
	
	public void addAddMovementListener(AddMovementListener addMovementListener){
		addMovement.addActionListener(addMovementListener);
	}
	
	public void addBalanceListener(BalanceListener balanceListener){
		viewBalance.addActionListener(balanceListener);
	}


}
