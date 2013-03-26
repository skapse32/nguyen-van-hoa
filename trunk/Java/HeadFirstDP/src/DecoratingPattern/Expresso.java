package DecoratingPattern;

public class Expresso extends Beverage{
	
	public Expresso() {
		description = "Expresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
