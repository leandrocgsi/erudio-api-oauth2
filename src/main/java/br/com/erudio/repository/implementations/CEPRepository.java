package br.com.erudio.repository.implementations;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.erudio.repository.interfaces.ICEPRepository;
import br.com.erudio.restclient.gateway.AddressInfoGateway;
import br.com.erudio.restclient.model.AddressInfo;

@Repository
public class CEPRepository implements ICEPRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AddressInfoGateway gateway; 

	@Override
	public AddressInfo findAddressInfoByCEP(String cep) {
		return gateway.findAddressInfoByCEP(cep);
	}
}