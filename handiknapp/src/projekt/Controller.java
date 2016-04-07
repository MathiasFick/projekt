package projekt;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;

import java.nio.ByteBuffer;

public class Controller {

	public static void main (String [] args){
		// TODO Auto-generated method stub
		int glfwInitializationResult = glfwInit(); // initialize GLFW and store the result (pass or fail)
		glfwPollEvents();
		String name = glfwGetJoystickName(GLFW_JOYSTICK_1);
		glfwGetJoystickButtons(GLFW_JOYSTICK_1);

		ByteBuffer buttons = ByteBuffer.allocate(10);
        while (true) {
		  buttons = glfwGetJoystickButtons(GLFW_JOYSTICK_1);
		  System.out.format("Joyknappar = ");
		  for (int i=0; i<10; i++) {
		    buttons.position(i);
		    int Value = buttons.get();
		    System.out.format("%d ", Value); // OBS!!!
		    
		    if (i==0 && Value==1) {new MoveCursor().moveCursor(100,100);}
		    if (i==1 && Value==1) {new MoveCursor().moveCursor(200,100);}
		    if (i==2 && Value==1) {new MoveCursor().moveCursor(300,100);}
		    if (i==3 && Value==1) {new MoveCursor().moveCursor(400,100);}
		  }
		  System.out.println();
		  
        }

	}

}
