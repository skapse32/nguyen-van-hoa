package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cauhoi database table.
 * 
 */
@Embeddable
public class CauhoiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	@Column(name="BANGDANHGIA_ID", insertable=false, updatable=false)
	private int bangdanhgiaId;

	public CauhoiPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBangdanhgiaId() {
		return this.bangdanhgiaId;
	}
	public void setBangdanhgiaId(int bangdanhgiaId) {
		this.bangdanhgiaId = bangdanhgiaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CauhoiPK)) {
			return false;
		}
		CauhoiPK castOther = (CauhoiPK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.bangdanhgiaId == castOther.bangdanhgiaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.bangdanhgiaId;
		
		return hash;
	}
}