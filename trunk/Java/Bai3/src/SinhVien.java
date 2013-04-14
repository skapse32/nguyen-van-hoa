import java.io.Serializable;
import java.util.Date;


public class SinhVien implements Serializable{

	private String MSSV;
	private String Hoten;
	private String gioiTinh;
	private Date ntns;
	
	public SinhVien(String mSSV, String hoten, String gioiTinh, Date ntns) {
		super();
		MSSV = mSSV;
		Hoten = hoten;
		this.gioiTinh = gioiTinh;
		this.ntns = ntns;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNtns() {
		return ntns;
	}

	public void setNtns(Date ntns) {
		this.ntns = ntns;
	}

	@Override
	public String toString() {
		return "SinhVien : [" + Hoten +"]";
	}
	
}