package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import controller.Implementations.ViewVisitorsControllerImpl.BackListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class ViewVisitorsView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2336420746515571993L;

	int rank;
	final PrisonManagerJPanel center;
    final PrisonManagerJPanel south;
    final PrisonManagerJPanel north;
    final JButton back = new JButton("Back");
    final JLabel title = new JLabel("View Prisoners : ");
    JTable table = new JTable();
	
	public ViewVisitorsView(int rank){
		this.rank=rank;
		this.setSize(250, 300);
		
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
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
	 
	 public void createTable(JTable table){
	    	this.table=table;
	    	table.setPreferredScrollableViewportSize(new Dimension(200,200));
	        table.setFillsViewportHeight(true);
	        JScrollPane js=new JScrollPane(table);
	        js.setVisible(true);
	    	center.add(js);
	 }
}
