/**
 * 
 */
package Ex1_13;

/**
 * @author vanhoa
 * 
 */
public class Container {

	/**
	 * Bai Tap 1.13 Chuong 3 OOP
	 */
	// ===================================================================
	// field
	// ===================================================================
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	// ===================================================================
	// Constructor
	// ===================================================================
	public Container(int x1, int y1, int width, int height) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + width - 1;
		this.y2 = y1 + height - 1;
	}

	// ===================================================================
	// Getter and Setter
	// ===================================================================
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	// ===================================================================
	// method
	// ===================================================================
	public String toString() {
		return "Container at (" + x1 + "," + y1 + ") to (" + x2 + "," + y2
				+ ")";
	}

	public boolean collidesWith(Ball ball) {
		if (ball.getX() - ball.getRadius() <= this.x1
				|| ball.getX() + ball.getRadius() >= this.x2) {
			ball.reflectHorizontal();
			return true;
		}
		if (ball.getY() - ball.getRadius() <= this.y1
				|| ball.getY() + ball.getRadius() > this.x2) {
			ball.reflectVertical();
			return true;
		}
		return false;
	}
}
