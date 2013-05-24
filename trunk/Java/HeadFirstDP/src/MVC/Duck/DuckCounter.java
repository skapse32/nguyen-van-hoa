package MVC.Duck;

public class DuckCounter implements Quackable {

	Quackable duck;
	static int numberDuck = 0;
	
	public DuckCounter(Quackable duck) {
		super();
		this.duck = duck;
	}

	public static int getNumberDuck() {
		return numberDuck;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		duck.quack();
		numberDuck ++ ;
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
