package MVC.Duck;

public class DuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuckSimulator mSimulator = new DuckSimulator();
		AbstractDuckFactory factory = new CountingDuckFactory();
		mSimulator.simulate(factory);
	}
	
	void simulate(AbstractDuckFactory factory){
		Quackable mallardDuck = factory.createMallardDuck();
		Quackable rubberDuck = factory.createRubberDuck();
		Quackable duckCall = factory.createDuckCall();
		Quackable redHeadDuck = factory.createRedHeadDuck();
		Quackable goose = new GooseAdapter(new Goose());
		Flock mFlock = new Flock();
		mFlock.add(mallardDuck);
		mFlock.add(redHeadDuck);
		mFlock.add(duckCall);
		mFlock.add(rubberDuck);
		
		Quackable mallardDuck1 = factory.createMallardDuck();
		Quackable mallardDuck2 = factory.createMallardDuck();
		Quackable mallardDuck3 = factory.createMallardDuck();
		Quackable mallardDuck4 = factory.createMallardDuck();
		
		Flock mallardFlock = new Flock();
		mallardFlock.add(mallardDuck1);
		mallardFlock.add(mallardDuck2);
		mallardFlock.add(mallardDuck3);
		mallardFlock.add(mallardDuck4);
		
		mFlock.add(mallardFlock);
		
		System.out.println("Duck Simulator, With abstract factory");
		
		
		
		simulate(mFlock);
		
		System.out.println("MallardDuck Flock Simulator !!");
		
		simulate(mallardFlock);
		
		Quackologist mQuackologist = new Quackologist();
		mallardFlock.registerObserver(mQuackologist);
		mallardFlock.notifyObservers();
		
		System.out.println("Duck quacked " + DuckCounter.numberDuck + " Times");
		
		
	}
	
	void simulate(Quackable duck){
		duck.quack();
	}
}
