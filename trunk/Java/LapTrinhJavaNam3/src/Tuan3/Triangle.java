package Tuan3;

public class Triangle extends Shape {

	private double base;
	private double height;
	
	public Triangle(double base, double height,String color) {
		super(color);
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (base*height)/2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle[base :" + base + ", heigth:" + height
				+ ", Color : " + super.toString() + "]";
	}
	
	
}
