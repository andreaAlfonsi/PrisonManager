package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import controller.Implementations.Chart2ControllerImpl.BackListener;
import controller.Implementations.Chart2ControllerImpl.ComputeListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class Chart2View extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7544019926884838785L;
	
	final PrisonManagerJPanel center;
    final PrisonManagerJPanel south;
    final PrisonManagerJPanel north;
    final JLabel title= new JLabel("Percentuale crimini commessi");
	final JButton back=new JButton("Back");
	final JButton compute2=new JButton("Compute");
	int rank;
	
	public Chart2View(int rank){
		this.rank=rank;
		this.setSize(250, 300);
		
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
	 	this.getContentPane().add(BorderLayout.CENTER,center);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(compute2);
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

	public void addComputeListener(ComputeListener computeListener){
		compute2.addActionListener(computeListener);
	}
	
}