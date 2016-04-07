package projekt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
/**
 * MoveCursor metoder som anropas till KeyPress. 
 * @author Mathias
 *
 */
public class MoveCursor extends Thread {
	Robot robot;

	/**
	 * När metoden anropas flyttas muspekaren till de x och y - koordinatorerna
	 * som skickats med
	 * 
	 * @param x
	 *            - x-koordinatorn
	 * @param y
	 *            - y-koordinatorn
	 */
	public void moveCursor(int x, int y) {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(x, y);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * När metoden anropas trycker muspekaren
	 */
	public void clickCursor() {
		Robot robot;
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
