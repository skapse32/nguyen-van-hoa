import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable,Comparable<Book>{

	private String masach;
	private String tenSach;
	private String tacgia;
	private int namSB;
	
	public Book(String masach, String tenSach, String tacgia, int namSB) {
		super();
		this.masach = masach;
		this.tenSach = tenSach;
		this.tacgia = tacgia;
		this.namSB = namSB;
	}
	public String getMasach() {
		return masach;
	}
	
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public int getNamSB() {
		return namSB;
	}
	public void setNamSB(int namSB) {
		this.namSB = namSB;
	}
	
	@Override
	public String toString() {
		return "Book [masach=" + masach + ", tenSach=" + tenSach + ", tacgia="
				+ tacgia + ", namSB=" + namSB + "]";
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.getMasach().compareToIgnoreCase(o.getMasach());
	}
}
