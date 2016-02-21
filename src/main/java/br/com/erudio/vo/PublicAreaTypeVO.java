package br.com.erudio.vo;

import java.io.Serializable;

public class PublicAreaTypeVO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idPublicAreaType;
    private String publicAreaTypeDescription;

    public PublicAreaTypeVO() {}

	public Integer getIdPublicAreaType() {
		return idPublicAreaType;
	}

	public void setIdPublicAreaType(Integer idPublicAreaType) {
		this.idPublicAreaType = idPublicAreaType;
	}

	public String getPublicAreaTypeDescription() {
		return publicAreaTypeDescription;
	}

	public void setPublicAreaTypeDescription(String publicAreaTypeDescription) {
		this.publicAreaTypeDescription = publicAreaTypeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idPublicAreaType == null) ? 0 : idPublicAreaType.hashCode());
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
		PublicAreaTypeVO other = (PublicAreaTypeVO) obj;
		if (idPublicAreaType == null) {
			if (other.idPublicAreaType != null)
				return false;
		} else if (!idPublicAreaType.equals(other.idPublicAreaType))
			return false;
		return true;
	}
}