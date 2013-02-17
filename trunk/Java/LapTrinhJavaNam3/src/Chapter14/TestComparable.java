package Chapter14;

public class TestComparable {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ComparableRectangle o1 = new ComparableRectangle(4,5);
		ComparableRectangle o2 = new ComparableRectangle(0,1);
		
		System.out.println(ComparableRectangle.Max(o1, o2));
	}

}
