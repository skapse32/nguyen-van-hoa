package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bangdanhgia database table.
 * 
 */
@Entity
@NamedQuery(name="Bangdanhgia.findAll", query="SELECT b FROM Bangdanhgia b")
public class Bangdanhgia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tenbang;

	//bi-directional many-to-one association to BangdanhgiaKq
	@OneToMany(mappedBy="bangdanhgia")
	private List<BangdanhgiaKq> bangdanhgiaKqs;

	//bi-directional many-to-one association to Cauhoi
	@OneToMany(mappedBy="bangdanhgia")
	private List<Cauhoi> cauhois;

	public Bangdanhgia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenbang() {
		return this.tenbang;
	}

	public void setTenbang(String tenbang) {
		this.tenbang = tenbang;
	}

	public List<BangdanhgiaKq> getBangdanhgiaKqs() {
		return this.bangdanhgiaKqs;
	}

	public void setBangdanhgiaKqs(List<BangdanhgiaKq> bangdanhgiaKqs) {
		this.bangdanhgiaKqs = bangdanhgiaKqs;
	}

	public BangdanhgiaKq addBangdanhgiaKq(BangdanhgiaKq bangdanhgiaKq) {
		getBangdanhgiaKqs().add(bangdanhgiaKq);
		bangdanhgiaKq.setBangdanhgia(this);

		return bangdanhgiaKq;
	}

	public BangdanhgiaKq removeBangdanhgiaKq(BangdanhgiaKq bangdanhgiaKq) {
		getBangdanhgiaKqs().remove(bangdanhgiaKq);
		bangdanhgiaKq.setBangdanhgia(null);

		return bangdanhgiaKq;
	}

	public List<Cauhoi> getCauhois() {
		return this.cauhois;
	}

	public void setCauhois(List<Cauhoi> cauhois) {
		this.cauhois = cauhois;
	}

	public Cauhoi addCauhoi(Cauhoi cauhoi) {
		getCauhois().add(cauhoi);
		cauhoi.setBangdanhgia(this);

		return cauhoi;
	}

	public Cauhoi removeCauhoi(Cauhoi cauhoi) {
		getCauhois().remove(cauhoi);
		cauhoi.setBangdanhgia(null);

		return cauhoi;
	}

}