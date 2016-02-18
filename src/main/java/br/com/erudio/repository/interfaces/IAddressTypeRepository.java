package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.AddressType;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface IAddressTypeRepository extends IGenericRepository<AddressType>{

	AddressType findById(Integer id);
	AddressType findByName(String name);
	List<AddressType> findAll();

}