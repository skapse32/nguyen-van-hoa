package Chapter11;

public class Rectangle extends GeometricObject {
	//fields
	private double width;
	private double height;
	//constructor
	public Rectangle(){
		
	}
	public Rectangle(double width,double height){
		this.width = width;
		this.height = height;
	}
	public Rectangle(double width,double height,String color,boolean filled){
		this.height = height;
		this.width = width;
	}
	//getter and setter
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	//public method
	
	
	public double getArea(){
		return width*height;
	}
	public double getPerimeter(){
		return (width+height)*2;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The Rectangle is created " + getDateCreated()
				+ " and the infomation of it is [" + width + "," + height + "]";
	}
	
}
