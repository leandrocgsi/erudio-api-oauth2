package br.com.erudio.vo.base;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class BaseVO extends ResourceSupport{
	
	private Date insertDate;
	private Date updatedDate;
	private Integer idUserInsert;
	private Integer idUserUpdate;
	
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
		this.updatedDate = updatedDate;
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
}