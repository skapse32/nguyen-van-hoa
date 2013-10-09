package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the thoikhoabieu database table.
 * 
 */
@Entity
@NamedQuery(name="Thoikhoabieu.findAll", query="SELECT t FROM Thoikhoabieu t")
public class Thoikhoabieu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDSV")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDGV")
	private User user2;

	//bi-directional many-to-one association to Monhoc
	@ManyToOne
	private Monhoc monhoc;

	//bi-directional one-to-one association to BangdanhgiaKq
	@OneToOne
	@JoinColumn(name="ID")
	private BangdanhgiaKq bangdanhgiaKq;

	public Thoikhoabieu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public Monhoc getMonhoc() {
		return this.monhoc;
	}

	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}

	public BangdanhgiaKq getBangdanhgiaKq() {
		return this.bangdanhgiaKq;
	}

	public void setBangdanhgiaKq(BangdanhgiaKq bangdanhgiaKq) {
		this.bangdanhgiaKq = bangdanhgiaKq;
	}

}