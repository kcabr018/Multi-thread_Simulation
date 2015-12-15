//=================================
// Author:	Kevin Cabrera
// Filename:	BallPanel.java
//=================================
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallPanel extends JPanel{
	private int x, y, delay, stepX, stepY;
	private Color ballColor, backColor;
	private Timer timer;
	final int CIRCLE_DIAMETER = 20;

	//x, y, ballColor, and backColor are initialized to the values of four 
	//parameters. delay should be initialized to 20, stepX should be initialized 
	//to 3, and stepY should be initialized to 0. The background should be set to 
	//the color that the variable "backColor" contains. Timer should be instantiated 
	//with "delay" and the listener object created from MovingBallListener class. 
	//Then it should start by calling start() method in the constructor.
	public BallPanel(int x, int y, Color ballColor, Color backColor)
	{
		this.x = x;
		this.y = y;
		this.ballColor = ballColor;
		this.backColor = backColor;
		delay = 20;
		stepX = 3;
		stepY = 0;
		setBackground(backColor);
		timer = new Timer(delay, new MovingBallListener());
		timer.start();
	}

	//Because we want the ball to start moving up, we set stepX to 0 
	//and stepY to -3. The timer should start again using its start method.
	public void up()
	{
		stepX = 0;
		stepY = -3;
		timer.start();
	}
	//Because we want the ball to start moving down, we set stepX to 0 and 
	//stepY to 3. The timer should start again using its start method.
	public void down()
	{
		stepX = 0;
		stepY = 3;
		timer.start();
	}
	//Because we want the ball to start moving left, we set stepX to -3 and 
	//stepY to 0. The timer should start again using its start method.
	public void left()
	{
		stepX = -3;
		stepY = 0;
		timer.start();
	}
	//Because we want the ball to start moving right, we set stepX to 3 and 
	//stepY to 0. The timer should start again using its start method.
	public void right()
	{
		stepX = 3;
		stepY = 0;
		timer.start();
	}
	//The timer should stop using its stop method.
	public void suspend()
	{
		timer.stop();
	}
	//This method set the delay of the timer using its parameter.
	public void setDelay(int delayNum)
	{
		timer.setDelay(delayNum);
	}
	//A color of the ball should be set, and a ball should be drawn using the 
	//(x,y) coordinate and CIRCLE_DIAMETER.
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.setColor(ballColor);
		page.fillOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
	}

	public class MovingBallListener implements ActionListener{
		//Its actionPerformed method implements how the ball should move by adding 
		//stepX and stepY to the corresponding variable, and re-paint the BallPanel 
		//after such change. In case the ball hits the side of the panel, it needs to 
		//reverse its direction. The width of the panel can be obtained by
		//"getSize().getWidth()". For instance, you can check if the ball hits the 
		//right hand side wall by:
		//if (x > getSize().getWidth()-CIRCLE_DIAMETER && stepY == 0)
		//You should make use of methods such as up(), down(), left(), and right() 
		//created above.
		public void actionPerformed(ActionEvent event)
		{
			x += stepX;
			y += stepY;
			if (x <= 0 || x >= getSize().getWidth() - CIRCLE_DIAMETER)
				stepX = stepX * -1;

			if (y <= 0 || y >= getSize().getHeight()- CIRCLE_DIAMETER)
				stepY = stepY * -1;
			repaint();
		}
	}
}
