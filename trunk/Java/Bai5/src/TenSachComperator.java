import java.util.Comparator;


public class TenSachComperator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTenSach().compareTo(o2.getTenSach());
	}

}
