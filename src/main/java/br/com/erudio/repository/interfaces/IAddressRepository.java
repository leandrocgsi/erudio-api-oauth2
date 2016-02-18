package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.Address;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface IAddressRepository extends IGenericRepository<Address>{

	Address findById(Integer id);
	List<Address> findAll();
	
}