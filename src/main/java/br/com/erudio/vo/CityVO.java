package br.com.erudio.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CityVO implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    private Integer idCity;
    private String name;
    
    @JsonCreator
    public CityVO() {}

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
		CityVO other = (CityVO) obj;
		if (idCity == null) {
			if (other.idCity != null)
				return false;
		} else if (!idCity.equals(other.idCity))
			return false;
		return true;
	} 
}