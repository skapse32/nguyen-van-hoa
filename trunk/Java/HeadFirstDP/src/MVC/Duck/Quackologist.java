package MVC.Duck;

public class Quackologist implements Observer {

	@Override
	public void update(QuackObservable observable) {
		// TODO Auto-generated method stub
		System.out.println("Quackologist : " + observable + " just quacked");
	}

}
