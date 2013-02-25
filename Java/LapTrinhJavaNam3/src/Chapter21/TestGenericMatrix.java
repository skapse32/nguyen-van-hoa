package Chapter21;

public class TestGenericMatrix {
	public static void main(String[] args){
		Integer[][] m1 = {{1,2,3},{4,5,6},{1,1,1}};
		Integer[][] m2 = {{1,1,1},{2,2,2},{0,0,0}};
		IntegerMatrix matrix = new IntegerMatrix();
		
		GenericMatrix.printResult(m1, m2, matrix.addMatrix(m1, m2), '+');
	}
}
