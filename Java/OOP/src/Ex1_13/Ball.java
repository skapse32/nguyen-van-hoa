/**
 * 
 */
package Ex1_13;

/**
 * @author vanhoa
 * 
 */
public class Ball {

	/**
	 * Bai Tap Chuong 03 OOP Bai 1.13
	 */
	// ===================================================================
	// field
	// ===================================================================
	private float x;
	private float y;
	private int radius;
	private double xDelta;
	private double yDelta;

	// ===================================================================
	// Constructor
	// ===================================================================
	public Ball(float x, float y, int radius, float speed, float direction) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.xDelta = speed * Math.cos(direction);
		this.yDelta = speed * Math.sin(direction);
	}

	// ===================================================================
	// Getter and Setter
	// ===================================================================
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getxDelta() {
		return xDelta;
	}

	public void setxDelta(float xDelta) {
		this.xDelta = xDelta;
	}

	public double getyDelta() {
		return yDelta;
	}

	public void setyDelta(float yDelta) {
		this.yDelta = yDelta;
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}

	// ===================================================================
	// method
	// ===================================================================
	public void move() {
		x += xDelta;
		y += yDelta;
	}

	public void reflectHorizontal() {
		// khi banh va vao` truc tung
		this.xDelta = -this.xDelta;
	}

	public void reflectVertical() {
		this.yDelta = -this.yDelta;
	}

	public String toString() {
		return "Ball at (" + x + "," + y + ") of velocity ("+xDelta+", "+yDelta+")";
	}
}
