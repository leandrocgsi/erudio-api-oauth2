package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name="city")
public class City implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    @Id
    @GeneratedValue
    @Column(name="IdCity", nullable=false)
    private Integer idCity;
    
    @Column(name="Name", length=80, nullable=false)
    private String name;
    
    @JsonCreator
    public City() {}

	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCity == null) ? 0 : idCity.hashCode());
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
		City other = (City) obj;
		if (idCity == null) {
			if (other.idCity != null)
				return false;
		} else if (!idCity.equals(other.idCity))
			return false;
		return true;
	}
}