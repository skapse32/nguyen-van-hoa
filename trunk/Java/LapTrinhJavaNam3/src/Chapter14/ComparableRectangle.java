package Chapter14;
import Chapter11.*;

class ComparableRectangle extends Rectangle implements Comparable{

	

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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(this.getArea() > ((ComparableRectangle)o).getArea())
			return 1;
		else if(this.getArea() < ((ComparableRectangle)o).getArea())
			return -1;
		else
			return 0;
	}
	
}
