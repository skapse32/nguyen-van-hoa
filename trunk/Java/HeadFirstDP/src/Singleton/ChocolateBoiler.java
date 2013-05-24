package Singleton;

public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;
	private static int num =1 ;
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void fill() {
		if (isEmpty()) {
			System.out.println("Fill chocolate and milk");
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain boilder mil
			System.out.println("Drain chocolate and milk");
			empty = true;
		}
	}

	public void boild() {
		if (!isEmpty() && !isBoiled()) {
			// bring content to a boil
			System.out.println("Bring content to a boil");
			boiled = true;
		}
	}

	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null){
			System.out.println((num++));
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}
}
