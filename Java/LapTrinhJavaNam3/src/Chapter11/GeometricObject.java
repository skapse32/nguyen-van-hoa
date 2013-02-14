/**
 * 
 */
package Chapter11;

import java.util.Date;

/**
 * @author VANHOA
 *
 */
public abstract class GeometricObject {

	/**
	 * Chuong 11 ke thua va da hinh
	 */
	//fields
	private String color;
	private boolean filled;
	private Date dateCreated;
	
	//Constructor
	public GeometricObject() {
		// TODO Auto-generated constructor stub
		dateCreated = new Date();
	}
	public GeometricObject(String color,boolean filled){
		this.color = color;
		this.filled = filled;
		dateCreated = new Date();
	}
	
	//getter va setter
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	//Method
	public abstract double getArea();
	public abstract double getPerimeter();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Color : " + color + " , Filled : " +filled + " , Date : " + dateCreated + "]";
	}
}
