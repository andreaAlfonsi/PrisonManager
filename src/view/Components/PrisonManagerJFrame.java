package view.Components;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PrisonManagerJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4583640093618196192L;

	String logoPath="res/logo.png";
	ImageIcon img = new ImageIcon(logoPath);
	
	
	public PrisonManagerJFrame(){
		this.setIconImage(img.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
