package Chapter21;

public abstract class GenericMatrix<E extends Number> {

	public abstract E add(E o1, E o2);

	public abstract E multiply(E o1, E o2);

	public abstract E zero();

	public E[][] addMatrix(E[][] o1, E[][] o2) {
		if (o1.length != o2.length || o1[0].length != o2.length) {
			throw new RuntimeException("Two matrix dont' have the same size");
		}
		E[][] result = (E[][]) new Number[o1.length][o1[0].length];
		for (int i = 0; i < o1.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = add(o1[i][j], o2[i][j]);
			}
		}
		return result;
	}

	public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
		if (matrix1[0].length != matrix2.length) {
			throw new RuntimeException(
					"Number of line of matrix1 don't equals to number of column of matrix2");
		}

		E[][] result = (E[][]) new Number[matrix1[0].length][matrix2.length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = zero();
				for (int k = 0; k < matrix1[0].length; k++) {
					result[i][j] = add(result[i][j],
							multiply(matrix1[i][k], matrix2[k][j]));
				}
			}
		}
		return result;
	}
	
	public static void printResult(Number[][] matrix1,Number[][] matrix2,Number[][] matrix3,char op){
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				System.out.print(" "+matrix1[i][j]);
			}
			if (i == matrix1.length/2) {
				System.out.print(" " + op + " ");
			}else{
				System.out.print("   ");
			}
			
			for (int j = 0; j < matrix2[i].length; j++) {
				System.out.print(" " + matrix2[i][j]);
			}
			
			if (i == matrix1.length/2) {
				System.out.print(" "+"="+" ");
			} else {
				System.out.print("   ");
			}
			for (int j = 0; j < matrix3[i].length; j++) {
				System.out.print(" "+matrix3[i][j]);
			}
			
			System.out.println();
		}
	}
}
