package Chapter11;

import java.util.ArrayList;

public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList myList = new ArrayList();
		myList.add("London");
		myList.add("Denver");
		myList.add("Paris");
		myList.add("Miami");
		myList.add("Seol");
		
		System.out.println("Is Denver in myList : " + myList.contains("Denver"));
		System.out.println("Location of Paris in myList : " + myList.indexOf("Paris"));
		
		myList.set(2, "Ha noi");
		System.out.println("Location of paris in myList : " + myList.indexOf("Paris"));
		
		System.out.println(myList.toString());
	}

}
