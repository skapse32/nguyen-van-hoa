import java.awt.Graphics;
import java.io.Serializable;
import java.util.Comparator;


public abstract class DrawObject implements Serializable{

	public abstract void draw(Graphics g);
	
	public abstract String getStartPoint();
	
	public abstract String getEndPoint();
	
	public abstract double dienTich();

	
}
