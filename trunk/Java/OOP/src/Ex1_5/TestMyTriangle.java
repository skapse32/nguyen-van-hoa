/**
 * 
 */
package Ex1_5;

/**
 * @author vanhoa
 * 
 */
public class TestMyTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint p1 = new MyPoint(3, 0);
		MyPoint p2 = new MyPoint(0, 4);
		MyPoint p3 = new MyPoint(0,0);
		
		MyTriangle myTriangle = new MyTriangle(p1, p2, p3);
		System.out.println(myTriangle);
		System.out.println(myTriangle.printType());
		System.out.println(myTriangle.getPerimeter());
	}

}
