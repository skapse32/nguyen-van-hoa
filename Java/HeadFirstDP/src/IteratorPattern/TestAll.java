package IteratorPattern;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Waitress mWaitress = new Waitress(new DinerMenu(), new PancakeHouseMenu());
		mWaitress.printMenu();
	}

}
