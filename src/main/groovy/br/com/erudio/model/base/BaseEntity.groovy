package br.com.erudio.model.base

import java.util.Date

import javax.persistence.Column;;
import javax.persistence.Temporal

class BaseEntity {

//	@Column (name="InsertDate", nullable = false)
//	@Temporal(javax.persistence.TemporalType.DATE)
	Date insertDate;

//	@Column (name="UpdatedDate", nullable = false)
//	@Temporal(javax.persistence.TemporalType.DATE)
	Date updatedDate = new Date();
}