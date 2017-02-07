package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Implementations.AddMovementControllerImpl.BackListener;
import controller.Implementations.AddMovementControllerImpl.InsertListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class AddMovementView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3724774108126619974L;
	
	String[] value = { "+", "-"};
    final PrisonManagerJPanel center;
    final PrisonManagerJPanel south;
    final PrisonManagerJPanel north;
    final JLabel title= new JLabel("Add a movement");
    final JLabel v = new JLabel("Value");
    final JLabel simbolo = new JLabel("+ : -");
    final JLabel desc = new JLabel("Description");
    final JTextField input = new JTextField(6);
    final JTextField input_desc = new JTextField(6);
    final JComboBox<?> values;
	final JButton back=new JButton("back");
	final JButton insert=new JButton("insert");
	int rank;
	public AddMovementView(int rank)
	{
		this.rank=rank;
		this.setSize(250, 300);
		
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
		values = new JComboBox<String>(value);
	    values.setSelectedItem(1);
	    center.add(simbolo);
	    center.add(values);
	    center.add(v);
	    center.add(input);
	    center.add(desc);
	    center.add(input_desc);
	
		SpringUtilities.makeCompactGrid(center,
	            3, 2, //rows, cols
	            6, 6,        //initX, initY
	            6, 6);       //xPad, yPad
		this.getContentPane().add(BorderLayout.CENTER,center);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(insert);
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
	
	public void addInsertListener(InsertListener insertListener){
		insert.addActionListener(insertListener);
	}
	
	public String getDesc(){
		return input_desc.getText();
	}
	
	public int getValue(){
		return Integer.valueOf(input.getText());
	}
	
	public String getSimbol(){		
		return String.valueOf(values.getSelectedItem());
	}
	
	public void displayErrorMessage(String error){
		JOptionPane.showMessageDialog(this, error);
	}

}
