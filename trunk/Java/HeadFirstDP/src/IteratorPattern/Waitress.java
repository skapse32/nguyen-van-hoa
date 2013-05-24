package IteratorPattern;

public class Waitress {

	DinerMenu mDinerMenu;
	PancakeHouseMenu mHouseMenu;
	public Waitress(DinerMenu mDinerMenu, PancakeHouseMenu mHouseMenu) {
		this.mDinerMenu = mDinerMenu;
		this.mHouseMenu = mHouseMenu;
	}
	
	public void printMenu(){
		Iterator breafast = mHouseMenu.createIterator();
		Iterator dinner = mDinerMenu.createIterator();
		System.out.println("MENU\n--\nBreakfast");
		printMenu(breafast);
		System.out.println("\nLuch");
		printMenu(dinner);
	}
	
	private void printMenu(Iterator iterator){
		while(iterator.hasNext()){
			MenuItem item = (MenuItem)iterator.Next();
			System.out.print(item.getName() + ", " + item.getPrice() + "--");
			System.out.println(item.getDescription());			
		}
	}
}
