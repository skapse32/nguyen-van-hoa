package MVC.Duck;

import java.util.ArrayList;
import java.util.Iterator;

public class Observable implements QuackObservable{

	ArrayList<Observer> observers = new ArrayList<Observer>();
	QuackObservable duck;
	
	public Observable(QuackObservable duck) {
		super();
		this.duck = duck;
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()){
			Observer observer = (Observer)it.next();
			observer.update(duck);
		}
	}

}
