package br.com.erudio.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

@MappedSuperclass
public class BaseEntity {
	
	@Column (name="InsertDate", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date insertDate;

	@Column (name="UpdatedDate", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date updatedDate;
	
	@Column (name="IdUserInsert", nullable = false)
	private Integer idUserInsert;
	
	@Column (name="IdUserUpdate")
	private Integer idUserUpdate;
	
	@Column (name="Active")
	private Boolean active;

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = new Date();
	}

	public Integer getIdUserInsert() {
		return idUserInsert;
	}

	public void setIdUserInsert(Integer idUserInsert) {
		this.idUserInsert = idUserInsert;
	}

	public Integer getIdUserUpdate() {
		return idUserUpdate;
	}

	public void setIdUserUpdate(Integer idUserUpdate) {
		this.idUserUpdate = idUserUpdate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}