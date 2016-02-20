package br.com.erudio.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import br.com.erudio.vo.AddressVO;
import br.com.erudio.vo.AddressTypeVO;
import br.com.erudio.vo.CityVO;
import br.com.erudio.vo.PublicAreaTypeVO;
import br.com.erudio.vo.StateVO;

public class AddressVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer idAddress;
    private String neighborhood;
    private String streetName;
    private String postalCode;
    private Integer number;
    private String complement;

    private PublicAreaTypeVO publicAreaType;
    private StateVO state;
    private AddressTypeVO addressType;
    private CityVO city;   

    public AddressVO() {
        this.city = new CityVO();
        this.state = new StateVO();
        this.publicAreaType = new PublicAreaTypeVO();
        this.addressType = new AddressTypeVO();
    }

	public Integer getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public PublicAreaTypeVO getPublicAreaType() {
		return publicAreaType;
	}

	public void setPublicAreaType(PublicAreaTypeVO publicAreaType) {
		this.publicAreaType = publicAreaType;
	}

	public StateVO getState() {
		return state;
	}

	public void setState(StateVO state) {
		this.state = state;
	}

	public AddressTypeVO getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressTypeVO addressType) {
		this.addressType = addressType;
	}

	public CityVO getCity() {
		return city;
	}

	public void setCity(CityVO city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAddress == null) ? 0 : idAddress.hashCode());
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
		AddressVO other = (AddressVO) obj;
		if (idAddress == null) {
			if (other.idAddress != null)
				return false;
		} else if (!idAddress.equals(other.idAddress))
			return false;
		return true;
	}  
}