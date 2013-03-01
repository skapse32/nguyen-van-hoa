package Tuan3;

public class MoveablePoint implements Moveable {

	private int x, y;

	public MoveablePoint() {
		super();
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}

	public MoveablePoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point At [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		y--;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		y++;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		x--;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		x++;
	}

}
