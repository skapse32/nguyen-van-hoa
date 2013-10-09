package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private byte gioitinh;

	private String hoten;

	@Temporal(TemporalType.DATE)
	private Date ngaysinh;

	private String noisinh;

	private int typeaccount;

	//bi-directional many-to-one association to Thoikhoabieu
	@OneToMany(mappedBy="user1")
	private List<Thoikhoabieu> thoikhoabieus1;

	//bi-directional many-to-one association to Thoikhoabieu
	@OneToMany(mappedBy="user2")
	private List<Thoikhoabieu> thoikhoabieus2;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(byte gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getHoten() {
		return this.hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getNoisinh() {
		return this.noisinh;
	}

	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}

	public int getTypeaccount() {
		return this.typeaccount;
	}

	public void setTypeaccount(int typeaccount) {
		this.typeaccount = typeaccount;
	}

	public List<Thoikhoabieu> getThoikhoabieus1() {
		return this.thoikhoabieus1;
	}

	public void setThoikhoabieus1(List<Thoikhoabieu> thoikhoabieus1) {
		this.thoikhoabieus1 = thoikhoabieus1;
	}

	public Thoikhoabieu addThoikhoabieus1(Thoikhoabieu thoikhoabieus1) {
		getThoikhoabieus1().add(thoikhoabieus1);
		thoikhoabieus1.setUser1(this);

		return thoikhoabieus1;
	}

	public Thoikhoabieu removeThoikhoabieus1(Thoikhoabieu thoikhoabieus1) {
		getThoikhoabieus1().remove(thoikhoabieus1);
		thoikhoabieus1.setUser1(null);

		return thoikhoabieus1;
	}

	public List<Thoikhoabieu> getThoikhoabieus2() {
		return this.thoikhoabieus2;
	}

	public void setThoikhoabieus2(List<Thoikhoabieu> thoikhoabieus2) {
		this.thoikhoabieus2 = thoikhoabieus2;
	}

	public Thoikhoabieu addThoikhoabieus2(Thoikhoabieu thoikhoabieus2) {
		getThoikhoabieus2().add(thoikhoabieus2);
		thoikhoabieus2.setUser2(this);

		return thoikhoabieus2;
	}

	public Thoikhoabieu removeThoikhoabieus2(Thoikhoabieu thoikhoabieus2) {
		getThoikhoabieus2().remove(thoikhoabieus2);
		thoikhoabieus2.setUser2(null);

		return thoikhoabieus2;
	}

}