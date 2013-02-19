/**
 * 
 */
package Ex1_7;

/**
 * @author vanhoa
 *
 */
public class TestMyPolynomial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPolynomial p1 = new MyPolynomial(1.1,2.2);
		MyPolynomial p2 = new MyPolynomial(0);
		System.out.println(p1.envaluate(2));
		System.out.println(p1.add(p2));
		System.out.println(p1.multiply(p2));
	}

}
