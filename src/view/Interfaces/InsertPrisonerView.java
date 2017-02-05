package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Implementations.InsertPrisonerControllerImpl.InsertPrisonerListener;
import controller.Implementations.InsertPrisonerControllerImpl.BackListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;

public class InsertPrisonerView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3914632428464622887L;

	final PrisonManagerJPanel south;
	final JButton insert = new JButton("Insert");
	final PrisonManagerJPanel north;
	final JLabel prisonerID = new JLabel("Prisoner ID");
	final JTextField prisonerID1 = new JTextField(2);
	final JLabel name = new JLabel("Name");
	final JTextField name1 = new JTextField(6);
	final JLabel surname = new JLabel("Surname");
	final JTextField surname1 = new JTextField(6);
	final JLabel birthDate = new JLabel("birth Date");
	final JTextField birthDate1 = new JTextField(6);
	final PrisonManagerJPanel center;
	final JLabel start = new JLabel("Start of imprisonment");
	final JTextField start1 = new JTextField(8);
	final JLabel end = new JLabel("End of imprisonment");
	final JTextField end1 = new JTextField(8);
	final JButton back = new JButton("Back");
	String pattern = "MM/dd/yyyy";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    Date date;
	
	public InsertPrisonerView(){
		this.setSize(500, 130);
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(prisonerID);
		north.add(prisonerID1);
		north.add(name);
		north.add(name1);
		north.add(surname);
		north.add(surname1);	
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new FlowLayout());
		north.add(birthDate);
		north.add(birthDate1);
		center.add(start);
		center.add(start1);
		center.add(end);
		center.add(end1);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(insert);
		south.add(back);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		this.getContentPane().add(BorderLayout.CENTER,center);
		this.setVisible(true);
	}
	
	public void addInsertPrisonerListener(InsertPrisonerListener addPrisonerListener){
		insert.addActionListener(addPrisonerListener);
	}
	
	public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}

	public int getPrisonerID1() {
		return Integer.valueOf(prisonerID1.getText());
	}

	public String getName1() {
		return name1.getText();
	}

	public String getSurname1() {
		return surname1.getText();
	}

	public Date getStart1() {
		try {
			date = format.parse(start1.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public Date getEnd1() {
		try {
			date = format.parse(end1.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public Date getBirth1() {
		try {
			date = format.parse(birthDate1.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public void displayErrorMessage(String error){
		JOptionPane.showMessageDialog(this, error);
	}
	
}