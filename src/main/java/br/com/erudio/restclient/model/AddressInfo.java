package br.com.erudio.restclient.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("WebCepDF")
public class AddressInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XStreamAlias("resultado")
    private String result;
	
    @XStreamAlias("resultadotxt")
    private String resultTxt;
    
    @XStreamAlias("uf")
    private String uf;
    
    @XStreamAlias("cidade")
    private String city;
    
    @XStreamAlias("bairro")
    private String town;
    
    @XStreamAlias("tipologradouro")
    private String addressType;
    
    @XStreamAlias("logradouro")
    private String street;

    public AddressInfo() {}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultTxt() {
		return resultTxt;
	}

	public void setResultTxt(String resultTxt) {
		this.resultTxt = resultTxt;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}