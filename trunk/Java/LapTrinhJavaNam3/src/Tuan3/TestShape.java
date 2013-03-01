package Tuan3;

public class TestShape {

	public static void main(String[] args) {
		Shape[] myArray = new Shape[3];
		
		myArray[0] = new Triangle(1.0, 2.0, "Red");
		myArray[1] = new Triangle(2.0, 3.0, "Green");
		myArray[2] = new Rectangle(3.0, 4.0, "Blue");
		
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}

}
