package Chapter14;

import Chapter11.*;

class ComparableRectangle extends Rectangle implements Comparable, Cloneable {

	public ComparableRectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComparableRectangle(double width, double height, String color,
			boolean filled) {
		super(width, height, color, filled);
		// TODO Auto-generated constructor stub
	}

	public ComparableRectangle(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static Object Max(Object o1, Object o2) {
		if (((ComparableRectangle) o1).compareTo(o2) >= 0)
			return o1;
		else
			return o2;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (this.getArea() > ((ComparableRectangle) o).getArea())
			return 1;
		else if (this.getArea() < ((ComparableRectangle) o).getArea())
			return -1;
		else
			return 0;
	}

	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
