package controller.Implementations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Interfaces.Visitor;
import view.Interfaces.AddVisitorsView;
import view.Interfaces.MoreFunctionsView;


public class AddVisitorsControllerImpl {
	
	static AddVisitorsView visitorsView;
	
	public AddVisitorsControllerImpl(AddVisitorsView view)
	{
		AddVisitorsControllerImpl.visitorsView=view;
		visitorsView.addBackListener(new BackListener());
		visitorsView.addInsertVisitorListener(new InsertListener());
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			visitorsView.dispose();
			new MoreFunctionsControllerImpl(new MoreFunctionsView(visitorsView.getRank()));
		}
		
	}
	
	public static class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			List<Visitor> visitor = null;
			try {
				visitor = getVisitor();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			Visitor vi = visitorsView.getVisitor();
				visitor.add(vi);
				File f = new File("res/Visitors.txt");
				FileOutputStream fo = null;
				try {
					fo = new FileOutputStream(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				ObjectOutputStream os = null;
				try {
					os = new ObjectOutputStream(fo);
				} catch (IOException e) {
					e.printStackTrace();
				}
				for(Visitor g1 : visitor){
					try {
						os.writeObject(g1);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					os.close();
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		public static List<Visitor> getVisitor() throws IOException, ClassNotFoundException
		{
			File f = new File("res/Visitors.txt");
			if(f.length()!=0){
				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				List<Visitor> visit = new ArrayList<>();
				
				try{
					while(true){
						Visitor s = (Visitor) oi.readObject();
						visit.add(s);
					}
				}catch(EOFException eofe){}
				
				fi.close();
				oi.close();
				return visit;
			}
				return new ArrayList<Visitor>();
		}
		}
	
		
	}


