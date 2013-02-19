/**
 * 
 */
package Ex1_6;

/**
 * @author vanhoa
 * 
 */
public class TestMyComplex {

	/**
	 * @param args
	 *            Test Class Complex
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyComplex p1 = new MyComplex(1.1, 2.2);
		MyComplex p2 = new MyComplex(3.3, 4.4);
		
		// Test 2 method isReal() and isImagi()=============================
		System.out.println("P1 is " + (p1.isReal() == true ? "TRUE" : "NOT")
				+ " a pure real number");
		System.out.println("P1 is "
				+ (p1.isImaginary() == true ? "TRUE" : "NOT")
				+ " a pure imaginary number");
		
		// Test method Equal()===========================================
		System.out.println("P1 "
				+ (p1.equals(1.1, 2.2) == true ? "Equal" : "NOT equal")
				+ " Complex(1.1,2.2)");
		System.out.println("P1 "
				+ (p1.equals(p2) == true ? "Equal" : "NOT Equal")
				+ " p2 complex");
		
		// Test method magnitude()========================================
		System.out.println("Magnitude of p1 = " + p1.magnitude());
		
		// Test method argumentInRadians()================================
		System.out.println("Argument of p1 in Radian = "
				+ p1.argumentInRadians());
		System.out.println("Argument of p1 in Degrees = "
				+ p1.argumentInDegrees());
		
		// Test method conjugate()========================================
		System.out.println("Conjugate of p1 is " + p1.conjugate());
		
		//Test method add,subtract,multi,div==============================
		System.out.println(" p3 = p2 + p1 = " +p1.add(p2) );
		System.out.println(" p3 = p2 - p1 = " +p1.subtract(p2) );
		System.out.println(" p3 = p2 * p1 = " +p1.multiplyWith(p2) );
		System.out.println(" p3 = p2 / p1 = " +p1.divideBy(p2) );
	}

}
