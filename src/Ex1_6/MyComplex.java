/**
 * 
 */
package Ex1_6;

/**
 * @author vanhoa
 * 
 */
public class MyComplex {

	// ===================================================================
	// field
	// ===================================================================

	private double real;
	private double imag;

	// ===================================================================
	// Constructor
	// ===================================================================

	public MyComplex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	// ===================================================================
	// Getter and Setter
	// ===================================================================

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void setValue(double real, double imag) {
		this.imag = imag;
		this.real = real;
	}

	// ===================================================================
	// method
	// ===================================================================

	public String toString() {
		// TODO Auto-generated method stub
		return "( " + real + "+" + imag + "i)";
	}

	public boolean isReal() {
		return (imag == 0);
	}

	public boolean isImaginary() {
		return (real == 0);
	}

	public boolean equals(double real, double imag) {
		// TODO Auto-generated method stub
		return (this.real == real && this.imag == imag);
	}

	public boolean equals(MyComplex p1) {
		return (this.real == p1.getReal() && this.imag == p1.getImag());
	}

	public double magnitude() {
		return Math.sqrt(real * real + imag * imag);
	}
}
