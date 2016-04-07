package projekt;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.MouseInfo;
import projekt.MoveCursor;

/**
 * Klass som används för att hitta x och y-koordinater 
 * @author Karolin 
 *
 */

public class PositionFinder implements NativeKeyListener{
	private Robot robot; 
	private int posX, posY;
	private String allPositions = "POSITIONER: \n"; 
	
	
	/**
	 * Metod som lyssnar efter knapptryck av "A" och "S"
	 * När man trycker A sparas x och y-koordinaterna som muspekaren befinner sig på
	 */
	
	  public void nativeKeyPressed(NativeKeyEvent e) {
		  
		  if ( e.getKeyCode() == NativeKeyEvent.VC_A) {
			  
			  //hämta x och y koordinater  
			 posX =  MouseInfo.getPointerInfo().getLocation().x;
			 posY = MouseInfo.getPointerInfo().getLocation().y;
			 
			 allPositions += "\nPosition X: " + posX + "\nPosition Y: " + posY + "\n";  
		  }
		  
	  if ( e.getKeyCode() == NativeKeyEvent.VC_S) {
			  
		  
		  //flytta muspekaren till de sparade x och y koordinaterna
		  try {
			robot = new Robot();
			robot.mouseMove(posX, posY);
			
		} catch (AWTException e1) {

			e1.printStackTrace();
		}
		  }
		  
	  
	  //när man trycker på Escape avslutas programmet  och alla sparade x och y koordinater skrivs ut i konsol-fönstret
	       if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
	            try { 
					GlobalScreen.unregisterNativeHook();
				} catch (NativeHookException e1) {
					System.out.println("funkar ej"); 
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	            //Skriv ut alla positioner: 
	            System.out.println(allPositions);
	       }
		  
	    }

	public void nativeKeyReleased(NativeKeyEvent arg0) {
		
	}


	public void nativeKeyTyped(NativeKeyEvent arg0) {
		
	}
	
	
	public static void main (String[] args) {
		   try {
	            GlobalScreen.registerNativeHook();
	        }
	        catch (NativeHookException ex) {
	            System.err.println("There was a problem registering the native hook.");
	        }

	        GlobalScreen.addNativeKeyListener(new PositionFinder());
	    }
}

