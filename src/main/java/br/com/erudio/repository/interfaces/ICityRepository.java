package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.City;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface ICityRepository extends IGenericRepository<City>{

	void deleteById(Integer id);
	City findByName(String name);
	City findById(Integer id);
	List<City> findAll();
	
}