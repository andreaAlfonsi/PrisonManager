package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class MainView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2585136897389059255L;

	final PrisonManagerJPanel left;
	final JButton addPrisoner= new JButton("Add prisoner");
	final JButton removePrisoner=new JButton("Remove prisoner");;
	final JButton viewPrisoner=new JButton("View prisoner");
	final PrisonManagerJPanel right;
	final JButton highRankOnly = new JButton("Supervisors only functions");
	final JButton moreFunctions = new JButton("More functions");
	final JButton logout=new JButton("Logout");
	
	public MainView(){
		this.setSize(400, 400);
		this.getContentPane().setLayout(new BorderLayout());
		left = new PrisonManagerJPanel(new FlowLayout());
		left.add(addPrisoner);
		left.add(removePrisoner);
		left.add(viewPrisoner);
		this.getContentPane().add(BorderLayout.WEST,left);
		right=new PrisonManagerJPanel(new FlowLayout());
		right.add(highRankOnly);
		right.add(moreFunctions);
		right.add(logout);
		this.getContentPane().add(BorderLayout.EAST,right);
		this.setVisible(true);
	}
	
	
}