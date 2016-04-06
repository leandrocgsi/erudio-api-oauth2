package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="public_area_type")
public class PublicAreaType implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdPublicAreaType", nullable = false)
    private Integer idPublicAreaType;
    
    @Column(name = "PublicAreaTypeDescription", nullable = false, length = 40)
    private String publicAreaTypeDescription;

    public PublicAreaType() {}

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
		result = prime * result + ((idPublicAreaType == null) ? 0 : idPublicAreaType.hashCode());
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
		PublicAreaType other = (PublicAreaType) obj;
		if (idPublicAreaType == null) {
			if (other.idPublicAreaType != null)
				return false;
		} else if (!idPublicAreaType.equals(other.idPublicAreaType))
			return false;
		return true;
	}
}