package Chapter10;

public class Cynlinder extends Circle {

	private double height;

	public Cynlinder() {
		super();
		this.height = 1.0;
	}

	public Cynlinder(double radius) {
		super(radius);
	}

	public Cynlinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume(){
		return super.getArea()*height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return super.getArea()*height + 2*super.getArea();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cynlinder[radius :"+getRadius() + ", height : " + getHeight() + "]";
	}
	
	
}
