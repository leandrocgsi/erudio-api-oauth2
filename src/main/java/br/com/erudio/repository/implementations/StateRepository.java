package br.com.erudio.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.State;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.IStateRepository;

@Repository
@Transactional(readOnly = true)
public class StateRepository extends GenericRepository<State> implements IStateRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(StateRepository.class);

	public StateRepository() {
		super(State.class);
	}
	
	@Override
	public State findById(Integer id) {
		try {
			return entityManager.createQuery("select p from State p where p.idState = :idState", State.class).setParameter("idState", id).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new State();
		}
	}
	
	@Override
	public State findByName(String name) {
		try {
			return entityManager.createQuery("select p from State p where p.stateName like :stateName", State.class).setParameter("stateName", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new State();
		} 
	}
	
	@Override
	public List<State> findAll() {
		try {
			return entityManager.createQuery("select p from State p", State.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return new ArrayList<State>();
		}
	}
}