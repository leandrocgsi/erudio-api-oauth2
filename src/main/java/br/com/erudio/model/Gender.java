package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.erudio.model.Gender;

@Entity
@Table(name="gender")
public class Gender implements Serializable {
    
    private static final long serialVersionUID =  1L;   
    
    @Id
    @GeneratedValue
    @Column(name="IdGender",nullable=false)
    private Integer idGender;
    
    @Column(name="Description", unique=true, nullable=false, length=9)
    private String description;

    public Gender() {}

	public Integer getIdGender() {
		return idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idGender == null) ? 0 : idGender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gender other = (Gender) obj;
		if (idGender == null) {
			if (other.idGender != null)
				return false;
		} else if (!idGender.equals(other.idGender))
			return false;
		return true;
	}
}