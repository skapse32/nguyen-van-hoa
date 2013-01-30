/**
 * 
 */
package Ex1_5;

/**
 * @author vanhoa
 * 
 */
public class MyPoint {

	/**
	 * Bai Tap Chuong 3 : OOP Bai 1.3 de lam bai 1.5
	 */
	// field
	private int x;
	private int y;

	// constructor
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}

	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Getter and Setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// method
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Point[" + x + "," + y + "]";
	}
	public double distance(int x,int y){	//ham tinh khoang cach giua 2 diem
		return Math.sqrt(Math.pow(x - this.x, 2)
				+ Math.pow(y - this.y, 2));
	}
	public double distance(MyPoint p1) {
		return Math.sqrt(Math.pow(p1.getX() - this.x, 2)
				+ Math.pow(p1.getY() - this.y, 2));
	}
}
