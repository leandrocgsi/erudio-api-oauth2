package br.com.erudio.restclient.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WebCepDF")
public class AddressInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultado", required = true)
    private String result;
    @XmlElement(name = "resultadotxt", required = true)
    private String resultTxt;
    @XmlElement(name = "uf", required = true)
    private String uf;
    @XmlElement(name = "cidade", required = true)
    private String city;
    @XmlElement(name = "bairro", required = true)
    private String town;
    @XmlElement(name = "tipologradouro", required = true)
    private String addressType;
    @XmlElement(name = "logradouro", required = true)
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