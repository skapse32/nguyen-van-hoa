package Chapter21;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<String> myStack = new GenericStack<>();
		myStack.push("London");
		myStack.push("NY");
		myStack.push("VietNam");
		
		GenericStack<Integer> myStack1 = new GenericStack<Integer>();
		myStack1.push(1);
		myStack1.push(2);
		
		Test.testMethod(myStack1);
	}

	public static <E> void testMethod(E o){
		System.out.println(o);
	}
	
}
