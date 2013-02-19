package Ex1_13;

public class TestBallClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ball myBall = new Ball(50, 50, 5, 10, 30);
		Container box = new Container(0, 0, 100, 100);
		for (int step = 0; step < 100; step++) {
			myBall.move();
			box.collidesWith(myBall);
			System.out.println(myBall); // manual check the position of the ball
		}
	}

}
