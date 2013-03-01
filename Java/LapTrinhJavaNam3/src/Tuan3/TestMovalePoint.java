package Tuan3;

public class TestMovalePoint {

	public static void main(String[] args){
		MoveablePoint mPoint = new MoveablePoint(40,50);
		mPoint.moveUp();
		System.out.println(mPoint);
		mPoint.moveDown();
		System.out.println(mPoint);
		mPoint.moveLeft();
		System.out.println(mPoint);
		mPoint.moveRight();
		System.out.println(mPoint);
	}
	
}
