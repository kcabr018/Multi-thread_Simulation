//===========================================
// Author: 	Kevin Cabrera
// Filename:	ControlPanel.java
// Description:	The ControlPanel represents 
//		a panel containing:
//		10 buttons,
//		2 sliders,
//		2 labels,
//		2 ball panels
//===========================================
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel{
	private BallPanel ball1, ball2;
	private int width, height;
	private JLabel label1, label2;
	private JPanel ballPanel, buttonPanel1, buttonPanel2, 
	sliderPanel1, sliderPanel2, settingsPanel;
	private JButton upRed, downRed, leftRed, rightRed, stopRed,
	upBlue, downBlue, leftBlue, rightBlue, stopBlue;
	private JSlider slider1, slider2;
	private int DIAMETER = 30;

	public ControlPanel(int width, int height){
		this.width = width;
		this.height = height;

		//create 2 ball panels
		ballPanel = new JPanel();
		ballPanel.setLayout(new GridLayout(2, 1));
		ball1 = new BallPanel(0, 65, Color.RED, Color.CYAN);
		ball2 = new BallPanel(0, 65, Color.BLUE, Color.YELLOW);	
		ballPanel.add(ball1);
		ballPanel.add(ball2);

		//create 10 buttons
		upRed = new JButton("Up Red");
		downRed = new JButton("Down Red");
		leftRed = new JButton("Left Red");
		rightRed = new JButton("Right Red");
		stopRed = new JButton("Stop Red");
		upBlue = new JButton("Up Blue");
		downBlue = new JButton("Down Blue");
		leftBlue = new JButton("Left Blue");
		rightBlue = new JButton("Right Blue");
		stopBlue = new JButton("Stop Blue");

		//create 2 sliders
		slider1 = new JSlider(JSlider.VERTICAL, 0, 50, 20);
		slider1.setMajorTickSpacing(10);
		slider1.setMinorTickSpacing(1);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);

		slider2 = new JSlider(JSlider.VERTICAL, 0, 50, 20);
		slider2.setMajorTickSpacing(10);
		slider2.setMinorTickSpacing(1);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);

		//add the corresponding listener to sliders and buttons
		ActionListener bListener = new ButtonListener();
		SliderListener sListener = new SliderListener();
		upRed.addActionListener(bListener);
		downRed.addActionListener(bListener);
		leftRed.addActionListener(bListener);
		rightRed.addActionListener(bListener);
		stopRed.addActionListener(bListener);
		upBlue.addActionListener(bListener);
		downBlue.addActionListener(bListener);
		leftBlue.addActionListener(bListener);
		rightBlue.addActionListener(bListener);
		stopBlue.addActionListener(bListener);
		slider1.addChangeListener(sListener);
		slider2.addChangeListener(sListener);

		//organize 5 buttons into a panel using grid layout
		buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new GridLayout(5, 1));
		buttonPanel1.add(upRed);
		buttonPanel1.add(downRed);
		buttonPanel1.add(leftRed);
		buttonPanel1.add(rightRed);
		buttonPanel1.add(stopRed);

		//organize 5 buttons into a panel using grid layout
		buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new GridLayout(5, 1));
		buttonPanel2.add(upBlue);
		buttonPanel2.add(downBlue);
		buttonPanel2.add(leftBlue);
		buttonPanel2.add(rightBlue);
		buttonPanel2.add(stopBlue);

		//create 2 labels
		label1 = new JLabel("Red Ball Delay");
		label2 = new JLabel("Blue Ball Delay");

		//organize a label and a slider into a panel using border layout
		sliderPanel1 = new JPanel();
		sliderPanel1.setLayout(new BorderLayout());
		sliderPanel1.add(label1, BorderLayout.NORTH);
		sliderPanel1.add(slider1, BorderLayout.CENTER);
		sliderPanel2 = new JPanel();
		sliderPanel2.setLayout(new BorderLayout());
		sliderPanel2.add(label2, BorderLayout.NORTH);
		sliderPanel2.add(slider2, BorderLayout.CENTER);

		//organize the panel containing buttons and the panel with a slider
		settingsPanel = new JPanel();
		settingsPanel.setLayout(new GridLayout(2, 2));
		settingsPanel.add(buttonPanel1);
		settingsPanel.add(sliderPanel1);
		settingsPanel.add(buttonPanel2);
		settingsPanel.add(sliderPanel2);

		//organize a label and a slider into a panel using border layout
		setLayout(new BorderLayout());
		add(settingsPanel, BorderLayout.WEST);
		add(ballPanel, BorderLayout.CENTER);	
	}


	//The ButtonListener class defines actions to be taken in case
	//each of 10 buttons are pushed.
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object action = event.getSource();

			//if the up button for the red ball is pushed.
			if (action == upRed)
				ball1.up();
			if (action == downRed)
				ball1.down();
			if (action == leftRed)
				ball1.left();
			if (action == rightRed)
				ball1.right();
			if (action == stopRed)
				ball1.suspend();
			if (action == upBlue)
				ball2.up();
			if (action ==downBlue)
				ball2.down();
			if (action == leftBlue)
				ball2.left();
			if (action == rightBlue)
				ball2.right();
			if (action == stopBlue)
				ball2.suspend();
		}
	} //end of ButtonListener

	//The SliderListener defines actions to be taken in case
	//each of the 2 sliders is moved by a user
	private class SliderListener implements ChangeListener{
		public void stateChanged(ChangeEvent event){
			if (event.getSource() == slider1)
				ball1.setDelay(slider1.getValue());
			else			
				ball2.setDelay(slider2.getValue());
		} //end of SliderListener

	}
}