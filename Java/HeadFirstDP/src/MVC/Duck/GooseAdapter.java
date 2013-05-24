package MVC.Duck;


public class GooseAdapter implements Quackable {

	Goose mGoose;
	
	public GooseAdapter(Goose mGoose) {
		super();
		this.mGoose = mGoose;
	}



	@Override
	public void quack() {
		// TODO Auto-generated method stub
		mGoose.honk();
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
