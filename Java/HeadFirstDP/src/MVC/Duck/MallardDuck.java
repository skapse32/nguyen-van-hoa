package MVC.Duck;


public class MallardDuck implements Quackable {
	Observable observable;
	
	public MallardDuck() {
		super();
		// TODO Auto-generated constructor stub
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("Quack");
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public String toString() {
		return "Mallard Duck";
	}
	
}
