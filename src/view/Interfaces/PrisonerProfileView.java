package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Implementations.ViewPrisonerControllerImpl.BackListener;
import controller.Implementations.ViewPrisonerControllerImpl.ViewProfileListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class PrisonerProfileView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7065438206105719545L;
	
	final PrisonManagerJPanel south;
	final JButton view = new JButton("View profile");
	final JButton back = new JButton("Back");
	final PrisonManagerJPanel north;
	final JLabel prisonerID = new JLabel("Prisoner ID");
	final JTextField prisonerID1 = new JTextField(2);
	final JLabel name;
	final JLabel name1;
	final JLabel surname;
	final JLabel surname1 ;
	final JLabel birthDate;
	final JLabel birthDate1;
	final JLabel start;
	final JLabel start1;
	final JLabel end;
	final JLabel end1;
	final PrisonManagerJPanel center;
	
	public PrisonerProfileView(){
		
		this.getContentPane().setLayout(new BorderLayout());
		center = new PrisonManagerJPanel(new SpringLayout());
		name = new JLabel("Name:		");
		name1 = new JLabel();
		center.add(name);
		center.add(name1);
		surname = new JLabel("Surname:	");
		surname1 = new JLabel();
		center.add(surname);
		center.add(surname1);
		birthDate = new JLabel("Birthdate:	");
		birthDate1 = new JLabel();
		center.add(birthDate);
		center.add(birthDate1);
		start = new JLabel("Reclusion start date:	");
		start1 = new JLabel();
		center.add(start);
		center.add(start1);
		end = new JLabel("Reclusion end date:	");
		end1 = new JLabel();
		center.add(end);
		center.add(end1);
		SpringUtilities.makeCompactGrid(center,
                5, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		this.getContentPane().add(BorderLayout.CENTER,center);
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(prisonerID);
		north.add(prisonerID1);
		this.getContentPane().add(BorderLayout.NORTH,north);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(view);
		south.add(back);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		this.setSize(450, 300);
		this.setVisible(true);
	}
	
	public void addViewListener(ViewProfileListener viewListener){
		view.addActionListener(viewListener);
	}

	public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}
	
	public int getID(){
		return Integer.valueOf(prisonerID1.getText());
	}
	
	public void setProfile(String name, String surname, String birthDate, String start, String end){
		this.name1.setText(name);
		this.surname1.setText(surname);
		this.birthDate1.setText(birthDate);
		this.start1.setText(start);
		this.end1.setText(end);
	}
	
	public void displayErrorMessage(String error){
		JOptionPane.showMessageDialog(this, error);
	}

}
