/**
 * 
 */
package Chart;

/**
 * @author vanhoa
 * 
 */
public class Rectangle {

	/**
	 * 
	 */
	// ===================================================================
	// field
	// ===================================================================
	private int width;
	private int height;
	private int x;
	private int y;

	// ===================================================================
	// Constructor
	// ===================================================================
	public Rectangle(int x, int y,int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y-height;
	}

	// ===================================================================
	// Getter and Setter
	// ===================================================================
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

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

	// ===================================================================
	// method
	// ===================================================================
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectanglr[" + x + "," + y + "]  Width = " + width
				+ ",Height = " + height;
	}
}
