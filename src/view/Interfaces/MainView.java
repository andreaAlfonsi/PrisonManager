package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.Implementations.MainControllerImpl.InsertPrisonerListener;
import controller.Implementations.MainControllerImpl.LogoutListener;
import controller.Implementations.MainControllerImpl.RemovePrisonerListener;
import controller.Implementations.MainControllerImpl.ViewPrisonerListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class MainView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2585136897389059255L;

	final PrisonManagerJPanel center;
	final JButton addPrisoner= new JButton("Add prisoner");
	final JButton removePrisoner=new JButton("Remove prisoner");;
	final JButton viewPrisoner=new JButton("View prisoner");
	final PrisonManagerJPanel south;
	final JButton highRankOnly = new JButton("Supervisors only functions");
	final JButton moreFunctions = new JButton("More functions");
	final JButton logout=new JButton("Logout");
	final PrisonManagerJPanel north;
	final JLabel title=new JLabel("Prison Manager");
	
	public MainView(){
		this.setSize(450, 150);
		this.getContentPane().setLayout(new BorderLayout());
		center = new PrisonManagerJPanel(new FlowLayout());
		center.add(addPrisoner);
		center.add(removePrisoner);
		center.add(viewPrisoner);
		this.getContentPane().add(BorderLayout.CENTER,center);
		south=new PrisonManagerJPanel(new FlowLayout());
		south.add(highRankOnly);
		south.add(moreFunctions);
		south.add(logout);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		this.setVisible(true);
	}
	
	public void addLogoutListener(LogoutListener logoutListener){
		logout.addActionListener(logoutListener);
	}
	
	public void addInsertPrisonerListener(InsertPrisonerListener insertPrisonerListener){
		addPrisoner.addActionListener(insertPrisonerListener);
	}
	
	public void addRemovePrisonerListener(RemovePrisonerListener removePrisonerListener){
		removePrisoner.addActionListener(removePrisonerListener);
	}
	
	public void addViewPrisonerListener(ViewPrisonerListener viewPrisonerListener){
		viewPrisoner.addActionListener(viewPrisonerListener);
	}
}
