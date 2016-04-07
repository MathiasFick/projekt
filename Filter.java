package testPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
* a filter that lies top of the game with components that symbolizes the physical buttons 
* 
* * @author Karolin
 *
 */

//behöver ändras så att ETT filter innehåller alla symboler,
// lägg alternativt in en inre klass för att skapa frames

public class Filter {
	private static JFrame frameLeft; 
	private static JFrame frameRight; 
	
//	ColorBox redBox = new ColorBox(new Color(225, 0 , 0, 100));
//	ColorBox blueBox = new ColorBox(new Color(0,225,0, 100));
//	ColorBox yellowBox = new ColorBox(new Color(225,225,0, 100));
//	ColorBox greenBox = new ColorBox(new Color(0,0,225, 100)); 

	public Filter(JFrame frame, Color box1, Color box2){
		frame.setUndecorated(true);
		frame.setBackground(new Color(0,0,0,0));
		frame.setPreferredSize(new Dimension(60, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new ColorBox(box1));
		frame.add(new ColorBox(box2));
		
		GridLayout grid = new GridLayout(2,1);
		grid.setHgap(10);
		grid.setVgap(10);

		frame.setLayout(grid);
		frame.setAlwaysOnTop(true);
		frame.pack();
		frame.setVisible(true);
	}
	
	public class ColorBox extends JPanel{ 

		public ColorBox (Color color){
			setPreferredSize(new Dimension(50,50));
			setBackground(color);        	
            setOpaque(true);
		}

	}
	
	//metoder som bör fyllas: 
	
	public void showFrames(){
		//anropas när svarsalternativen visas 
		frameLeft = new JFrame();
		frameLeft.setLocation(111, 583);
		Filter filterLeft = new Filter(frameLeft, new Color(225, 0 , 0, 150),new Color(0,225,0, 150));

		
		//yellow and blue rectangles : 
		
		frameRight = new JFrame();
		frameRight.setLocation(1158, 583);
		Filter filterRight = new Filter(frameRight, new Color(225, 225 , 0, 150), new Color(0, 0 , 225, 150));

	}
	
	
	public void closeFrames(){
		//anropas när spelaren har tryckt på ett svarsalternativ 
		frameRight.dispose();
		frameLeft.dispose();
	}
	
	
	
	public static void main (String [] args){
		
		//red and green rectangles : 		
		
		frameLeft = new JFrame();
		frameLeft.setLocation(111, 583);
		Filter filterLeft = new Filter(frameLeft, new Color(225, 0 , 0, 150),new Color(0,225,0, 150));

		
		//yellow and blue rectangles : 
		
		frameRight = new JFrame();
		frameRight.setLocation(1158, 583);
		Filter filterRight = new Filter(frameRight, new Color(225, 225 , 0, 150), new Color(0, 0 , 225, 150));

	}
	
}
