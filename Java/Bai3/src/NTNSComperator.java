import java.io.Serializable;
import java.util.Comparator;


public class NTNSComperator implements Comparator<SinhVien>, Serializable {

	@Override
	public int compare(SinhVien o1, SinhVien o2) {
		// TODO Auto-generated method stub
		return o1.getNtns().compareTo(o2.getNtns());
	}

}
