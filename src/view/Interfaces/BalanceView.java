package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import controller.Implementations.BalanceControllerImpl.BackListener;
import controller.Implementations.BalanceControllerImpl.ComputeListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class BalanceView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9027369697644712989L;
	
	final PrisonManagerJPanel center;
    final PrisonManagerJPanel south;
    final PrisonManagerJPanel north;
    final JButton compute = new JButton("Compute balance");
    final JButton back = new JButton("Back");
    final JLabel balance = new JLabel("Balance : ");
    JTable table = new JTable();
    
    private int rank;
    
    public BalanceView(int rank){
    	this.rank=rank;
		this.setSize(250, 300);
		
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(balance);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
		this.getContentPane().add(BorderLayout.CENTER,center);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(compute);
		south.add(back);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		this.setVisible(true);
    }

    public int getRank(){
    	return this.rank;
    }
    
    public void addComputeListener(ComputeListener computeListener){
    	compute.addActionListener(computeListener);
    }
    
    public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}
    
    public void setLabel(String bal){
    	balance.setText("Balance :  "+ bal);
    }
    
    public void createTable(JTable table){
    	this.table=table;
    	table.setPreferredScrollableViewportSize(new Dimension(200,200));
        table.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
    	center.add(js);
    }
}
