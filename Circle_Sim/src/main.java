//=======================================
// Name:	Kevin Cabrera
// Description: Execution of the program 
//				begins here. 
//=======================================
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.event.*;

public class main extends JApplet  {
	private final int WIDTH = 450;
	private final int HEIGHT = 300;

	public void init()
	{
		ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
		getContentPane().add(panel);
		setSize(WIDTH,HEIGHT);
	}
}
