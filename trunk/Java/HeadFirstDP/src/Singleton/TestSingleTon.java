package Singleton;

public class TestSingleTon {

	
	public static void main(String[] args){
		
		Runnable mRunnable1 = new ChocolateRunable("1");
		Runnable mRunnable2 = new ChocolateRunable("2");
		
		Thread thread1 = new Thread(mRunnable1);
		Thread thread2 = new Thread(mRunnable2);
		
		thread1.run();
		thread2.run();
	}
	

}

class ChocolateRunable implements Runnable{

	private String status;
	
	public ChocolateRunable(String status) {
		super();
		this.status = status;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		ChocolateBoiler myBoiler = ChocolateBoiler.getInstance();
		System.out.println(ChocolateBoiler.getInstance());
		myBoiler.fill();
		myBoiler.boild();
		myBoiler.drain();
	}
	
}