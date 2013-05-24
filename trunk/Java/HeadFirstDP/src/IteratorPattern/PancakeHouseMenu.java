package IteratorPattern;

import java.util.ArrayList;

public class PancakeHouseMenu {
	
	ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		addItem("K&B's Pancake Breakfast", 
				"Pancakes with scrambled eggs, and toast", 
				true,
				2.99);
	 
			addItem("Regular Pancake Breakfast", 
				"Pancakes with fried eggs, sausage", 
				false,
				2.99);
	 
			addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries",
				true,
				3.49);
	 
			addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true,
				3.59);

	}

	private void addItem(String string, String string2, boolean b, double d) {
		// TODO Auto-generated method stub
		MenuItem item = new MenuItem(string, string2, b, d);
		menuItems.add(item);
	}

	public Iterator createIterator(){
		return new PancakeHouseMenuIterator(menuItems);
	}
		
	
}
