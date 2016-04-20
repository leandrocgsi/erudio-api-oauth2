package br.com.erudio.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Gender;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.IGenderRepository;

@Repository
@Transactional(readOnly = true)
public class GenderRepository extends GenericRepository<Gender> implements IGenderRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(GenderRepository.class);

	public GenderRepository() {
		super(Gender.class);
	}
	
	@Override
	public List<Gender> findAll() {
		try {
			return entityManager.createQuery("select g from Gender g", Gender.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return new ArrayList<Gender>();
		}
	}
}