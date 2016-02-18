package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.PublicAreaType;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface IPublicAreaTypeRepository extends IGenericRepository<PublicAreaType>{

	PublicAreaType findById(Integer id);
	PublicAreaType findByName(String name);
	List<PublicAreaType> findAll();

}