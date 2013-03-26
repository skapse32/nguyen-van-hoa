package Chapter1Update;

public class ModelDuck extends Duck {

	public ModelDuck() {
		super();
		// TODO Auto-generated constructor stub
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	
	
	public void display(){
		System.out.println("/n I'm a model Duck!!");
	}
}
