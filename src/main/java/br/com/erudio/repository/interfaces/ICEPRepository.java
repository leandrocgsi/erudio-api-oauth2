package br.com.erudio.repository.interfaces;

import br.com.erudio.restclient.model.AddressInfo;

public interface ICEPRepository {

	AddressInfo findAddressInfoByCEP(String cep);
	
}