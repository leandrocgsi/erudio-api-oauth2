package br.com.erudio.repository.implementations;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.City;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.ICityRepository;

@Repository
@Transactional(readOnly = true)
public class CityRepository extends GenericRepository<City> implements ICityRepository{

	private static final long serialVersionUID = 1L;

	public CityRepository() {
		super(City.class);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
        try {
        	Query query = entityManager.createNamedQuery("City.deleteCityById").setParameter("idCity", id);
            query.executeUpdate(); 
        } catch (ConstraintViolationException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
        	entityManager.close();
        }
	}	
		
	public City findByName(String name) {
		try {
			return entityManager.createNamedQuery("City.findCityByName", City.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public City findById(Integer idCity) {
		try {
			return entityManager.createNamedQuery("City.findCityById", City.class).setParameter("idCity", idCity).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<City> findAll() {
		try {
			return (List<City>) entityManager.createNamedQuery("City.findAllCities", City.class).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
}