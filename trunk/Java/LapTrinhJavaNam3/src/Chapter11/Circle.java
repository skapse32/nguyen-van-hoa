/**
 * 
 */
package Chapter11;

/**
 * @author VANHOA
 * 
 */
public class Circle extends GeometricObject {

	// fields
	private double radius;

	// constructor
	public Circle() {
		// TODO Auto-generated constructor stub
		this.radius = 0.0;
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color,filled);
		this.radius = radius;
	}

	// getter and setter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// public method
	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}

	public double getDiameter() {
		return radius * 2;
	}

	public void PrintCirle() {
		System.out.println("The circle is created " + getDateCreated()
				+ " and the radius is " + radius);
	}

//	@Override
//	public boolean equals(Object arg0) {
//		// TODO Auto-generated method stub
//		return this.radius == ((Circle)arg0).radius;
//	}
	
	public boolean equals(Circle arg0) {
		// TODO Auto-generated method stub
		return this.radius == arg0.radius;
	}
}
