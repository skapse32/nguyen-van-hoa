import java.util.Comparator;


public class MaSachComperator implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		// TODO Auto-generated method stub
		return arg0.getMasach().compareTo(arg1.getMasach());
	}

}
