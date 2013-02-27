package Chapter10;

public class Rectangle extends Shape {

	private double width;
	private double heigth;

	public Rectangle(double length, double width,String color) {
		super(color);
		this.heigth = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return heigth * width;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle[length :" + heigth + ", width :" + width
				+ ", Color : " + super.toString() + "]";
	}

}
