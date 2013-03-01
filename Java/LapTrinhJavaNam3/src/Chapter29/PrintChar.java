package Chapter29;

public class PrintChar implements Runnable {

	private char c;
	private int time;
	
	public PrintChar(char c, int time) {
		super();
		this.c = c;
		this.time = time;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < time; i++) {
				System.out.print(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
