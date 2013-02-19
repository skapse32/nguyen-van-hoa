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
		if(imag<0){
			return "( " + real + imag + "i)";
		}
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

	public double argumentInRadians() {
		return Math.atan2(imag, real);
	}

	public int argumentInDegrees() {
		return (int) ((Math.atan2(imag, real) * 180) / Math.PI);
	}

	public MyComplex conjugate() {
		return new MyComplex(real, -imag);
	}
	//Ham Cong tru nhan chia so phuc.
	public MyComplex add(MyComplex p1) {
		return new MyComplex(this.real + p1.real, this.imag + p1.imag);
	}

	public MyComplex subtract(MyComplex p1) {
		return new MyComplex(this.real - p1.real, this.imag - p1.imag);
	}

	public MyComplex multiplyWith(MyComplex p1) {
		this.real = this.real * p1.real - this.imag * p1.imag; 
		this.imag = real * p1.imag+ imag * p1.real;
		return this;
	}
	public MyComplex divideBy(MyComplex p1){
		this.real = this.multiplyWith(p1).real/(p1.real*p1.real + p1.imag*p1.imag);
		this.imag = this.multiplyWith(p1).imag/(p1.real*p1.real + p1.imag*p1.imag);
		return this;
	}
}
