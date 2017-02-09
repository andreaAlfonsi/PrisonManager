package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Implementations.InsertGuardControllerImpl.BackListener;
import controller.Implementations.InsertGuardControllerImpl.InsertListener;
import model.Implementations.GuardImpl;
import model.Interfaces.Guard;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class InsertGuardView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6919464397187101572L;
	
	final PrisonManagerJPanel south;
	final JButton insert = new JButton("Insert");
	final PrisonManagerJPanel north;
	final JLabel guardID = new JLabel("Guard ID");
	final JTextField guardID1 = new JTextField(6);
	final JLabel name = new JLabel("Name");
	final JTextField name1 = new JTextField(6);
	final JLabel surname = new JLabel("Surname");
	final JTextField surname1 = new JTextField(6);
	final JLabel birthDate = new JLabel("birth Date (mm/gg/aaaa)");
	final JTextField birthDate1 = new JTextField(6);
	final PrisonManagerJPanel center;
	final JLabel guardRank = new JLabel("Rank");
	final JTextField guardRank1 = new JTextField(8);
	final JLabel telephoneNum = new JLabel("Telephone number");
	final JTextField telephoneNum1 = new JTextField(8);
	final JLabel password = new JLabel("Password");
	final JTextField password1 = new JTextField(8);
	final JButton back = new JButton("Back");
	final JLabel title = new JLabel("Insert a guard");
	String pattern = "MM/dd/yyyy";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    Date date;
	int rank;
	
	public InsertGuardView(int rank){
		this.rank=rank;
		this.setSize(450, 400);
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		center = new PrisonManagerJPanel(new SpringLayout());
		center.add(guardID);
		center.add(guardID1);
		center.add(name);
		center.add(name1);
		center.add(surname);
		center.add(surname1);	
		center.add(birthDate);
		center.add(birthDate1);
		center.add(telephoneNum);
		center.add(telephoneNum1);
		center.add(guardRank);
		center.add(guardRank1);
		center.add(password);
		center.add(password1);
		SpringUtilities.makeCompactGrid(center,
                7, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		this.getContentPane().add(BorderLayout.CENTER,center);
		south = new PrisonManagerJPanel(new FlowLayout());
		south.add(insert);
		south.add(back);
		this.getContentPane().add(BorderLayout.SOUTH,south);
		this.setVisible(true);
	}
	
	public void addBackListener(BackListener backListener){
		back.addActionListener(backListener);
	}
	
	public void addInsertListener(InsertListener insertListener){
		insert.addActionListener(insertListener);
	}

	public int getRank() {
		return this.rank;
	}
	
	public Guard getGuard(){
		Date birth = null;
		try {
			birth = format.parse(birthDate1.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Guard g = new GuardImpl(name1.getText(),surname1.getText(),birth,Integer.valueOf(guardRank1.getText()),telephoneNum1.getText(),
				Integer.valueOf(guardID1.getText()),password1.getText());
		return g;
	}

}
