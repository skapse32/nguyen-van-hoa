package MVC.Duck;

public class CountingDuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		// TODO Auto-generated method stub
		return new DuckCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedHeadDuck() {
		// TODO Auto-generated method stub
		return new DuckCounter(new RedHeadDuck());
	}

	@Override
	public Quackable createDuckCall() {
		// TODO Auto-generated method stub
		return new DuckCounter(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() {
		// TODO Auto-generated method stub
		return new DuckCounter(new RubberDuck());
	}

}
