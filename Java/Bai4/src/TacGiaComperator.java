import java.util.Comparator;


public class TacGiaComperator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTacgia().compareTo(o2.getTacgia());
	}

}
