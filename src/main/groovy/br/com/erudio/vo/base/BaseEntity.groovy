package br.com.erudio.vo.base

import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal

import org.springframework.hateoas.ResourceSupport;

class BaseEntity extends ResourceSupport{
	
	Date insertDate;
	Date updatedDate = new Date();
	Integer idUserInsert;
	Integer idUserUpdate;
		
}