package Singleton;

public class Test {

	public static void main(String[] args){
		ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
		boiler1.fill();
		boiler1.boil();
		boiler1.drain();
	}
	
}
