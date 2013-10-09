package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bangdanhgia_kq database table.
 * 
 */
@Entity
@Table(name="bangdanhgia_kq")
@NamedQuery(name="BangdanhgiaKq.findAll", query="SELECT b FROM BangdanhgiaKq b")
public class BangdanhgiaKq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Bangdanhgia
	@ManyToOne
	@JoinColumn(name="IDBDG")
	private Bangdanhgia bangdanhgia;

	//bi-directional one-to-one association to Thoikhoabieu
	@OneToOne(mappedBy="bangdanhgiaKq")
	private Thoikhoabieu thoikhoabieu;

	public BangdanhgiaKq() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bangdanhgia getBangdanhgia() {
		return this.bangdanhgia;
	}

	public void setBangdanhgia(Bangdanhgia bangdanhgia) {
		this.bangdanhgia = bangdanhgia;
	}

	public Thoikhoabieu getThoikhoabieu() {
		return this.thoikhoabieu;
	}

	public void setThoikhoabieu(Thoikhoabieu thoikhoabieu) {
		this.thoikhoabieu = thoikhoabieu;
	}

}