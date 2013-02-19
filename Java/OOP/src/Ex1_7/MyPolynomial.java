package Ex1_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MyPolynomial {
	// ===================================================================
	// field
	// ===================================================================
	private double[] coeffs;

	// ===================================================================
	// Constructor
	// ===================================================================
	public MyPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}

	public MyPolynomial(String fileName) {
		Scanner in = null;
		try {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int degree = in.nextInt();
		coeffs = new double[degree + 1];
		for (int i = 0; i < coeffs.length; i++) {
			coeffs[i] = in.nextDouble();
		}
	}

	// ===================================================================
	// Getter and Setter
	// ===================================================================
	public double[] getCoeffs() {
		return coeffs;
	}

	public void setCoeffs(double[] coeffs) {
		this.coeffs = coeffs;
	}

	// ===================================================================
	// method
	// ===================================================================
	public int getDegree() {
		// Bac cua da thuc
		return coeffs.length - 1;
	}

	public String toString() {
		String res = "";
		for (int i = coeffs.length - 1; i > 0; i--) {
			res += coeffs[i] + "X^" + i + " + ";
		}
		res += coeffs[0];
		return res;
	}

	public double envaluate(double x) {
		double res = 0;
		for (int i = 0; i < coeffs.length; i++) {
			res += coeffs[i] * Math.pow(x, i);
		}
		return res;
	}

	public MyPolynomial add(MyPolynomial p1) {
		double[] res;
		if (coeffs.length <= p1.getCoeffs().length) {
			res = p1.getCoeffs().clone();
			for (int i = 0; i < coeffs.length; i++) {
				res[i] += coeffs[i];
			}
		} else {
			res = coeffs.clone();
			for (int i = 0; i < p1.getCoeffs().length; i++) {
				res[i] += p1.getCoeffs()[i];
			}
		}
		return new MyPolynomial(res);
	}

	public MyPolynomial multiply(MyPolynomial p1) {
		if (p1.getCoeffs().length == 1 && p1.getCoeffs()[0] == 0) {
			return new MyPolynomial(0);
		} else {
			double[] res = new double[coeffs.length + p1.getCoeffs().length - 1];
			MyPolynomial tempPoly = new MyPolynomial(res);
			for (int i = 0; i < p1.getCoeffs().length; i++) {
				double[] temp = new double[coeffs.length + i];
				int k = i;
				for (int j = 0; j < coeffs.length; j++) {
					temp[k++] = coeffs[j] * p1.getCoeffs()[i];
				}
				MyPolynomial tempPoly1 = new MyPolynomial(temp);
				tempPoly = tempPoly.add(tempPoly1);
			}
			return tempPoly;
		}
	}
}
