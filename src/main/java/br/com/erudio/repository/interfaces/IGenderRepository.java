package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.Gender;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface IGenderRepository extends IGenericRepository<Gender>{

	List<Gender> findAll();
	
}