import java.util.Comparator;


public class HoTenComperator implements Comparator<SinhVien> {

	@Override
	public int compare(SinhVien arg0, SinhVien arg1) {
		// TODO Auto-generated method stub
		return arg0.getHoten().compareTo(arg1.getHoten());
	}

}
