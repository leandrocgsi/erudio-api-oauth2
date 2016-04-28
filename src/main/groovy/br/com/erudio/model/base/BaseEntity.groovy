package br.com.erudio.model.base

import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal

@MappedSuperclass
class BaseEntity {
	
	@Column (name="InsertDate", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	Date insertDate;

	@Column (name="UpdatedDate", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	Date updatedDate = new Date();
	
	@Column (name="IdUserInsert", nullable = false)
	Integer idUserInsert;
	
	@Column (name="IdUserUpdate")
	Integer idUserUpdate;
		
}