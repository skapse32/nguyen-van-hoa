package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cauhoi database table.
 * 
 */
@Entity
@NamedQuery(name="Cauhoi.findAll", query="SELECT c FROM Cauhoi c")
public class Cauhoi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CauhoiPK id;

	private String noidung;

	//bi-directional many-to-one association to Bangdanhgia
	@ManyToOne
	private Bangdanhgia bangdanhgia;

	public Cauhoi() {
	}

	public CauhoiPK getId() {
		return this.id;
	}

	public void setId(CauhoiPK id) {
		this.id = id;
	}

	public String getNoidung() {
		return this.noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Bangdanhgia getBangdanhgia() {
		return this.bangdanhgia;
	}

	public void setBangdanhgia(Bangdanhgia bangdanhgia) {
		this.bangdanhgia = bangdanhgia;
	}

}