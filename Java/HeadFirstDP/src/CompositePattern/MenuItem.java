package CompositePattern;

public class MenuItem extends MenuComponent {

	String name;
	String description;
	double price;
	boolean vegatable;
	
	public MenuItem(String name, String description, double price,
			boolean vegatable) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.vegatable = vegatable;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public boolean isVegatable() {
		// TODO Auto-generated method stub
		return vegatable;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("" + getName());
		if(vegatable){
			System.out.print("(v)");
		}
		System.out.println("," + getPrice());
		System.out.println("   -- " + getDescription());
	}
	
	
}
