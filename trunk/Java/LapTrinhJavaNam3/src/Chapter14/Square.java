/**
 * 
 */
package Chapter14;

import Chapter11.GeometricObject;

/**
 * @author VANHOA
 * 
 */
public class Square extends GeometricObject implements Colorable {

	private double a;

	public Square() {
		// TODO Auto-generated constructor stub
		a = 0.0;
	}

	public Square(double a) {
		this.a = a;
	}

	public Square(String color, boolean filled, double a) {
		super(color, filled);
		// TODO Auto-generated constructor stub
		this.a = a;
	}

	@Override
	public void howToColor() {
		// TODO Auto-generated method stub
		System.out.println("Color all four sides");
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return a * a;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return a * 4;
	}

}
