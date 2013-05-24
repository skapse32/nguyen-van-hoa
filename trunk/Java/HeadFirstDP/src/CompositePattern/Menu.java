package CompositePattern;

import java.util.ArrayList;

public class Menu extends MenuComponent {

	ArrayList<MenuComponent> components = new ArrayList<MenuComponent>();
	String name;
	String description;
	
	public Menu(ArrayList<MenuComponent> components, String name,
			String description) {
		super();
		this.components = components;
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		components.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		components.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		// TODO Auto-generated method stub
		return components.get(i);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("/n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("--------------------");
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
	
}
