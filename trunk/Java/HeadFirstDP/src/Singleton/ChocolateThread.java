package Singleton;

public class ChocolateThread extends Thread {
	ChocolateBoiler boiler;
	public ChocolateThread() {
		super();
		boiler = ChocolateBoiler.getInstance();
	}

	@Override
	public void run() {
		super.run();
		boiler.fill();
		boiler.boil();
		boiler.drain();
	}
}
