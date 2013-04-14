import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;


public class CircleObject extends DrawObject implements Serializable{

	int x1,y1;
	int radius;

	public CircleObject(int x1, int y1, int r) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.radius = r;
	}


	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawOval(x1, y1, radius, radius);
	}


	@Override
	public String getStartPoint() {
		// TODO Auto-generated method stub
		return "[" + x1 + "," + y1+ "]";
	}


	@Override
	public String getEndPoint() {
		// TODO Auto-generated method stub
		return "[" + radius + "," + radius + "]";
	}


	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return radius*radius*Math.PI;
	}
	
}
