package Tuan3;

public class Circle {

	private double radius;
	private String color;

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
		radius = 1.0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getRadius() {
		return radius;
	}

}
