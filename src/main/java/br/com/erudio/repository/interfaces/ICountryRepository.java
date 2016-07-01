package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.Country;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface ICountryRepository extends IGenericRepository<Country>{

	void deleteById(Integer id);
	Country findByName(String name);
	Country findById(Integer id);
	List<Country> findAll();
	
}