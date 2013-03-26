package DecoratingPattern;

public class Mocha extends CondimentDecorate {

	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		// TODO Auto-generated constructor stub
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.beverage .getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .20 + this.beverage.cost();
	}

}
