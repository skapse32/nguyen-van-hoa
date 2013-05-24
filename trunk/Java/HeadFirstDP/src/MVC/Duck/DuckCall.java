package MVC.Duck;


public class DuckCall implements Quackable {

	Observable mObservable;
	
	
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("kwak");
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
