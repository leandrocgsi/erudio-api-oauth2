package br.com.erudio.vo;

import java.io.Serializable;

public class GenderVO implements Serializable {
    
    private static final long serialVersionUID =  1L;   
    
    private Integer idGender;
    private String description;

    public GenderVO() {}

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
		GenderVO other = (GenderVO) obj;
		if (idGender == null) {
			if (other.idGender != null)
				return false;
		} else if (!idGender.equals(other.idGender))
			return false;
		return true;
	}
}