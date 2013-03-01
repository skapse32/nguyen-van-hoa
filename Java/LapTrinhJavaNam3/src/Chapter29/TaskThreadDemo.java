package Chapter29;

public class TaskThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintChar tChar1 = new PrintChar('a', 100);
		PrintChar tChar2 = new PrintChar('b', 100);
		
		Thread mThread1 = new Thread(tChar1);
		Thread mThread2 = new Thread(tChar2);
		
		mThread1.start();
		mThread2.start();
		mThread1.setPriority(Thread.MAX_PRIORITY);
	}

}
