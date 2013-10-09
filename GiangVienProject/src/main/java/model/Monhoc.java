package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the monhoc database table.
 * 
 */
@Entity
@NamedQuery(name="Monhoc.findAll", query="SELECT m FROM Monhoc m")
public class Monhoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tenmh;

	//bi-directional many-to-one association to Thoikhoabieu
	@OneToMany(mappedBy="monhoc")
	private List<Thoikhoabieu> thoikhoabieus;

	public Monhoc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenmh() {
		return this.tenmh;
	}

	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}

	public List<Thoikhoabieu> getThoikhoabieus() {
		return this.thoikhoabieus;
	}

	public void setThoikhoabieus(List<Thoikhoabieu> thoikhoabieus) {
		this.thoikhoabieus = thoikhoabieus;
	}

	public Thoikhoabieu addThoikhoabieus(Thoikhoabieu thoikhoabieus) {
		getThoikhoabieus().add(thoikhoabieus);
		thoikhoabieus.setMonhoc(this);

		return thoikhoabieus;
	}

	public Thoikhoabieu removeThoikhoabieus(Thoikhoabieu thoikhoabieus) {
		getThoikhoabieus().remove(thoikhoabieus);
		thoikhoabieus.setMonhoc(null);

		return thoikhoabieus;
	}

}