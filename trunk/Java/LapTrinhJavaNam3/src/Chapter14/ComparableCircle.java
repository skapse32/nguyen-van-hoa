/**
 * 
 */
package Chapter14;

import Chapter11.Circle;

/**
 * @author VANHOA
 *
 */
public class ComparableCircle extends Circle implements Comparable {

	/**
	 * 
	 */
	public ComparableCircle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 */
	public ComparableCircle(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param radius
	 * @param color
	 * @param filled
	 */
	public ComparableCircle(double radius, String color, boolean filled) {
		super(radius, color, filled);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Object o) {
		if(this.getArea() > ((ComparableCircle)o).getArea())
			return 1;
		else if(this.getArea() < ((ComparableCircle)o).getArea())
			return -1;
		else
			return 0;
	}

}
