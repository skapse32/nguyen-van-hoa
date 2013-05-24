package IteratorPattern;

public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItem = 0;
	MenuItem[] items;

	public DinerMenu() {
		items = new MenuItem[MAX_ITEMS];

		addItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat", true,
				2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false,
				2.99);
		addItem("Soup of the day",
				"Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog",
				"A hot dog, with saurkraut, relish, onions, topped with cheese",
				false, 3.05);
		addItem("Steamed Veggies and Brown Rice",
				"Steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta",
				"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
				true, 3.89);
	}

	private void addItem(String string, String string2, boolean b, double d) {
		// TODO Auto-generated method stub
		MenuItem item = new MenuItem(string, string2, b, d);
		if(numberOfItem >= MAX_ITEMS){
			System.out.println("Sorry, menu is full!  Can't add item to menu");
		}else{
			items[numberOfItem] = item;
			numberOfItem++;
		}
	}

	public Iterator createIterator(){
		return new DinerMenuIterator(items);
	}
	
}
