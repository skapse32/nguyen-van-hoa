import java.io.Serializable;
import java.util.Comparator;


public class MssvComperator implements Comparator<SinhVien>,Serializable{

	@Override
	public int compare(SinhVien o1, SinhVien o2) {
		// TODO Auto-generated method stub
		return o1.getMSSV().compareTo(o2.getMSSV());
	}

}
