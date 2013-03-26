package Chapter1Update;

public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}


	
	public void quackPerform(){
		quackBehavior.quack();
	}
	
	public void flyPerform(){
		flyBehavior.fly();
	}
}
