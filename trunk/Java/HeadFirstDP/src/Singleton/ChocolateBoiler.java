package Singleton;

public class ChocolateBoiler {

	private boolean empty;
	private boolean boiled;

	private static ChocolateBoiler uniqueChocolateBoiler = new ChocolateBoiler();

	private ChocolateBoiler() {
		empty = true;
		boiled = true;
	}

	public static ChocolateBoiler getInstance() {
		if (uniqueChocolateBoiler == null) {
			uniqueChocolateBoiler = new ChocolateBoiler();
			System.out.println("Creating unique instance of Chocolate Boiler");
		}
		System.out.println("Returning instance of Chocolate Boiler");
		return uniqueChocolateBoiler;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void setBoiled(boolean boiled) {
		this.boiled = boiled;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
}
