package Chapter1Update;

public class MallardDuck extends Duck{
	
	public MallardDuck() {
		super();
		// TODO Auto-generated constructor stub
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
}
