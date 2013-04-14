import java.awt.Graphics;
import java.io.Serializable;


public class LineObject extends DrawObject implements Serializable{

	int x1,y1;
	int x2,y2;
	
	public LineObject(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(x1, y1, x2, y2);
	}


	@Override
	public String getStartPoint() {
		// TODO Auto-generated method stub
		return "[" + x1 + "," + y1 + "]";
	}

	@Override
	public String getEndPoint() {
		// TODO Auto-generated method stub
		return "[" + x2 + "," + y2 + "]";
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return Math.abs((x2-x1)*(y2-y1));
	}
	
}
