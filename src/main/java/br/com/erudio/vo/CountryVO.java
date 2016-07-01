package br.com.erudio.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class CountryVO extends ResourceSupport implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    private Integer idCountry;
    private String name;
    private String localeMessageKey; 
    private String states;  
    
    public CountryVO() {}

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocaleMessageKey() {
		return localeMessageKey;
	}

	public void setLocaleMessageKey(String localeMessageKey) {
		this.localeMessageKey = localeMessageKey;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCountry == null) ? 0 : idCountry.hashCode());
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
		CountryVO other = (CountryVO) obj;
		if (idCountry == null) {
			if (other.idCountry != null)
				return false;
		} else if (!idCountry.equals(other.idCountry))
			return false;
		return true;
	}
}