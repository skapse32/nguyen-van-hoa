package Chapter18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel {

	private int delay = 10;
	private Timer mTimer = new Timer(delay, new TimerListener());

	private int x = 0;
	private int y = 0;
	private int radius = 5;
	private int dx = 2;
	private int dy = 2;

	public Ball() {
		super();
		// TODO Auto-generated constructor stub
		mTimer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.red);

		if (x < radius)
			dx = Math.abs(dx);
		if (x > getWidth() - radius)
			dx = -Math.abs(dx);
		if (y < radius)
			dy = Math.abs(dy);
		if (y > getHeight() - radius)
			dy = -Math.abs(dy);

		x += dx;
		y += dy;
		
		g.drawOval(x, y, radius*2, radius*2);
	}

	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
		}

	}

	// method=================================================
	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void suspend() {
		mTimer.stop();
	}

	public void resume() {
		mTimer.start();
	}
}
