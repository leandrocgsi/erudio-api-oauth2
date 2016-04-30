package br.com.erudio.vo;

import java.io.Serializable;

public class AddressInfoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String result;
    private String resultTxt;
    private String uf;
    private String city;
    private String town;
    private String addressType;
    private String street;

    public AddressInfoVO() {}

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