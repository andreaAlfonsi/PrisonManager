package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import controller.Implementations.SupervisorControllerImpl.BackListener;
import controller.Implementations.SupervisorControllerImpl.InsertGuardListener;
import controller.Implementations.SupervisorControllerImpl.RemoveGuardListener;
import controller.Implementations.SupervisorControllerImpl.ShowPrisonersListener;
import controller.Implementations.SupervisorControllerImpl.ViewGuardListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class SupervisorFunctionsView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1240198114577795025L;
	
	final PrisonManagerJPanel north;
	final JLabel title=new JLabel("Supervisor Functions");
	final PrisonManagerJPanel center;
	final JButton addGuard=new JButton("Add a guard");
	final JButton removeGuard=new JButton("Remove a guard");
	final JButton viewGuard=new JButton("View Guard");
	final JButton viewPrisoners=new JButton("View prisoners in a certain fraction of time");
	final PrisonManagerJPanel south;
	final JButton back=new JButton("Back");
	int rank;
	
	public SupervisorFunctionsView(int rank){
		this.rank=rank;
		this.setSize(415, 200);
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
		center.add(addGuard);
		center.add(removeGuard);
		center.add(viewGuard);
		center.add(viewPrisoners);
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

	public int getRank() {
		return rank;
	}
	
	public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}

	public void addShowPrisonersListener(ShowPrisonersListener showPrisonersListeners){
		viewPrisoners.addActionListener(showPrisonersListeners);
	}
	
	public void addInsertGuardListener(InsertGuardListener insertGaurdListener){
		addGuard.addActionListener(insertGaurdListener);
	}
	
	public void addRemoveGuardListener(RemoveGuardListener removeListener){
		removeGuard.addActionListener(removeListener);
	}
	
	public void addviewGuardListener(ViewGuardListener viewListener){
		viewGuard.addActionListener(viewListener);
	}
}
