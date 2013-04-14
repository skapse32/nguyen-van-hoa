import java.util.Comparator;


public class NamSBComperator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getNamSB() - o2.getNamSB());
		
	}

}
