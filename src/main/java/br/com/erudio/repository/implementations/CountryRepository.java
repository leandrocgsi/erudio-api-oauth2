package br.com.erudio.repository.implementations;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.Country;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.ICountryRepository;

@Repository
@Transactional(readOnly = true)
public class CountryRepository extends GenericRepository<Country> implements ICountryRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(CountryRepository.class);

	public CountryRepository() {
		super(Country.class);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
        try {
        	Query query = entityManager.createNamedQuery("Country.deleteCountryById").setParameter("idCountry", id);
            query.executeUpdate(); 
        } catch (ConstraintViolationException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
        	entityManager.close();
        }
	}	
		
	public Country findByName(String name) {
		try {
			return entityManager.createNamedQuery("Country.findCountryByName", Country.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		} 
	}
	
	public Country findById(Integer idCountry) {
		try {
			return entityManager.createNamedQuery("Country.findCountryById", Country.class).setParameter("idCountry", idCountry).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		}
	}
	
	public List<Country> findAll() {
		try {
			return (List<Country>) entityManager.createNamedQuery("Country.findAllCountries", Country.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		}
	}
}