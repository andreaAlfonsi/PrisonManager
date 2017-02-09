package view.Components;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class PieChart_AWT extends ApplicationFrame 
{ 
	private static final long serialVersionUID = -1753760388662708023L;
	
	static Map<String,Integer>map=new HashMap<>();
	
public PieChart_AWT( String title ,Map<String,Integer>map) 
   {
      super( title ); 
      PieChart_AWT.map=map;
      setContentPane(createDemoPanel( ));
      this.setSize(600, 600);
      RefineryUtilities.centerFrameOnScreen( this );    
      this.setVisible( true ); 
   }

   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      for(Map.Entry<String, Integer> e: map.entrySet()){
	    	dataset.setValue(String.valueOf(e.getKey()), e.getValue());
	    }
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Percentuale crimini",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
//   public static void main( String[ ] args )
//   {
//      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
//      demo.setSize( 560 , 367 );    
//      RefineryUtilities.centerFrameOnScreen( demo );    
//      demo.setVisible( true ); 
//   }
}
