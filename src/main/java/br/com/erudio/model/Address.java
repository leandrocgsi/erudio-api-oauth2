package br.com.erudio.model;

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

import br.com.erudio.model.Address;
import br.com.erudio.model.AddressType;
import br.com.erudio.model.City;
import br.com.erudio.model.PublicAreaType;
import br.com.erudio.model.State;

@SuppressWarnings("deprecation")
@Entity
@Table(name="address")
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdAddress", nullable=false)
    private Integer idAddress;
    
    @Column(name="Neighborhood", length=80)
    private String neighborhood;
    
    @Column (name="StreetName", length=80)
    private String streetName;
    
    @Column (name="PostalCode", length=9)
    private String postalCode;
    
    @Column (name="Number")
    private Integer number;
    
    @Column (name="Complement")
    private String complement;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ForeignKey(name="AddressPublicAreaType")
    @JoinColumn(name = "IdPublicAreaType", referencedColumnName = "IdPublicAreaType")
    private PublicAreaType publicAreaType;
    
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @ForeignKey(name="AddressState")
    @JoinColumn(name = "IdState", nullable = false)
    private State state;
        
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @ForeignKey(name="AddressAddressType")
    @JoinColumn(name = "IdAddressType", referencedColumnName="IdAddressType")
    private AddressType addressType;
    
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @ForeignKey(name="AddressCity")
    @JoinColumn(name = "IdCity", referencedColumnName="IdCity")
    private City city;   

    public Address() {
        this.city = new City();
        this.state = new State();
        this.publicAreaType = new PublicAreaType();
        this.addressType = new AddressType();
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

	public PublicAreaType getPublicAreaType() {
		return publicAreaType;
	}

	public void setPublicAreaType(PublicAreaType publicAreaType) {
		this.publicAreaType = publicAreaType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
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
		Address other = (Address) obj;
		if (idAddress == null) {
			if (other.idAddress != null)
				return false;
		} else if (!idAddress.equals(other.idAddress))
			return false;
		return true;
	}  
}