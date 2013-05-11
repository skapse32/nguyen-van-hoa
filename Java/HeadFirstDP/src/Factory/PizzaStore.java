package Factory;

public class PizzaStore {
	SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) {
		super();
		this.factory = factory;
	}
	public Pizza orderPizza(String type){
		Pizza pizza = factory.createPizza(type);
		pizza.prepair();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
