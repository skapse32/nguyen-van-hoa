package MVC.Duck;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {

	ArrayList<Quackable> quackers = new ArrayList<Quackable>();
	Observable duck;
	
	public void add(Quackable quacker){
		quackers.add(quacker);
	}
	
	public Flock() {
		super();
		// TODO Auto-generated constructor stub
		duck = new Observable(this);
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		Iterator<Quackable> it = quackers.iterator();
		while(it.hasNext()){
			Quackable quacker = (Quackable)it.next();
			quacker.quack();
		}
	}


	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		duck.registerObserver(observer);
	}


	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		duck.notifyObservers();
	}

}
