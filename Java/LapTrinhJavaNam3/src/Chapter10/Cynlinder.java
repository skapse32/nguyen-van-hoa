package Chapter10;

public class Cynlinder extends Circle {

	private double height;

	public Cynlinder() {
	}

	public Cynlinder(double radius) {
		super(radius);
	}

	public Cynlinder(double radius, double height) {
		super();
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

}
