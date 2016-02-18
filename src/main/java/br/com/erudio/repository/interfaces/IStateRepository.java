package br.com.erudio.repository.interfaces;

import java.util.List;

import br.com.erudio.model.State;
import br.com.erudio.repository.generic.IGenericRepository;;


public interface IStateRepository extends IGenericRepository<State>{

	State findById(Integer id);
	State findByName(String name);
	List<State> findAll();
	
}