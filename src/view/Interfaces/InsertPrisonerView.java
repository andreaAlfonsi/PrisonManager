package view.Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.Implementations.InsertPrisonerControllerImpl.AddCrimeListener;
import controller.Implementations.InsertPrisonerControllerImpl.BackListener;
import controller.Implementations.InsertPrisonerControllerImpl.InsertPrisonerListener;
import view.Components.PrisonManagerJFrame;
import view.Components.PrisonManagerJPanel;
import view.Components.SpringUtilities;

public class InsertPrisonerView extends PrisonManagerJFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3914632428464622887L;

	final PrisonManagerJPanel south;
	final JButton insert = new JButton("Insert");
	final PrisonManagerJPanel north;
	final JLabel prisonerID = new JLabel("Prisoner ID");
	final JTextField prisonerID1 = new JTextField(6);
	final JLabel name = new JLabel("Name");
	final JTextField name1 = new JTextField(6);
	final JLabel surname = new JLabel("Surname");
	final JTextField surname1 = new JTextField(6);
	final JLabel birthDate = new JLabel("birth Date");
	final JTextField birthDate1 = new JTextField(6);
	final PrisonManagerJPanel east;
	final PrisonManagerJPanel center;
	final JLabel start = new JLabel("Start of imprisonment");
	final JTextField start1 = new JTextField(8);
	final JLabel end = new JLabel("End of imprisonment");
	final JTextField end1 = new JTextField(8);
	final JLabel cell = new JLabel("Cell ID");
	final JTextField cell1 = new JTextField(8);
	final JButton back = new JButton("Back");
	final JLabel title = new JLabel("Insert a prisoner");
    final JComboBox<?> type;
    final JTextArea textArea;
    final JButton add=new JButton("Add crime");
	String[] crimes = {"Reati contro gli animali","Reati associativi","Blasfemia e sacrilegio","Reati economici e finanziari","Falsa testimonianza","Reati militari","Reati contro il patrimonio","Reati contro la persona","Reati nell' ordinamento italiano","Reati tributari","Traffico di droga","Casi di truffe"};
	String pattern = "MM/dd/yyyy";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
    Date date;
    private int rank;
	
	public InsertPrisonerView(int rank){
		this.rank=rank;
		this.setSize(450, 400);
		this.getContentPane().setLayout(new BorderLayout());
		north = new PrisonManagerJPanel(new FlowLayout());
		north.add(title);
		this.getContentPane().add(BorderLayout.NORTH,north);
		type = new JComboBox<String>(crimes);
	    type.setSelectedItem(0);
	    textArea = new JTextArea();
	    textArea.setEditable(false);
		east = new PrisonManagerJPanel(new SpringLayout());
		east.add(type);
		east.add(textArea);
	    JScrollPane logScrollPane = new JScrollPane(add);
		east.add(logScrollPane);
		SpringUtilities.makeCompactGrid(east,
                3, 1, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		this.getContentPane().add(BorderLayout.EAST,east);
		center = new PrisonManagerJPanel(new SpringLayout());
		center.add(prisonerID);
		center.add(prisonerID1);
		center.add(name);
		center.add(name1);
		center.add(surname);
		center.add(surname1);	
		center.add(birthDate);
		center.add(birthDate1);
		center.add(start);
		center.add(start1);
		center.add(end);
		center.add(end1);
		center.add(cell);
		center.add(cell1);
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
	
	public int getCellID() {
		return Integer.valueOf(this.cell1.getText());
	}
	
	public void displayErrorMessage(String error){
		JOptionPane.showMessageDialog(this, error);
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void setList(List<String>list){
		textArea.setText("");
		for(String s : list){
			textArea.append(s+"\n");
		}
	}
	
	public List<String> getList(){
		 String s[] = textArea.getText().split("\\r?\\n");
		 ArrayList<String>list = new ArrayList<>(Arrays.asList(s));
		 return list;
	}
	
	public String getCombo(){
		return type.getSelectedItem().toString();
	}
	
	public void addAddCrimeListener(AddCrimeListener addCrimeListener){
		add.addActionListener(addCrimeListener);
	}
}
