import java.util.Comparator;


public class DrawObjectComparator implements Comparator<DrawObject>{

	@Override
	public int compare(DrawObject o1, DrawObject o2) {
		// TODO Auto-generated method stub
		return (int) (o1.dienTich() - o2.dienTich());
	}

}
