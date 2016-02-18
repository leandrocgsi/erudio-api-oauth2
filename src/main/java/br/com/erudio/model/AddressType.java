package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.erudio.model.AddressType;

@Entity
@Table(name="address_type")
public class AddressType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdAddressType", nullable = false)
    private Integer idAddressType;
    
    @Column(name = "Description", nullable = false, length = 35)
    private String description;

    public AddressType() {}

	public Integer getIdAddressType() {
		return idAddressType;
	}

	public void setIdAddressType(Integer idAddressType) {
		this.idAddressType = idAddressType;
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
				+ ((idAddressType == null) ? 0 : idAddressType.hashCode());
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
		AddressType other = (AddressType) obj;
		if (idAddressType == null) {
			if (other.idAddressType != null)
				return false;
		} else if (!idAddressType.equals(other.idAddressType))
			return false;
		return true;
	}
}