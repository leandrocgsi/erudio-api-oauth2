package br.com.erudio.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.dto.PagedSearchDTO;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonPagedSearchRepository;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.IPersonRepository;


@Repository
public class PersonRepository extends GenericRepository<Person> implements IPersonRepository{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonPagedSearchRepository<Person> personPagedSearchRepository; 
	
	public PersonRepository() {
		super(Person.class);
	}
	
	@Override
	public List<Person> findAll() {
		try {
			List<Person> persons = (List<Person>) entityManager.createNamedQuery("Person.findAllPersons", Person.class).getResultList();
			return persons;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}

	@Override
	public Person findByName(String name) {
		try {
			return entityManager.createNamedQuery("Person.findPersonByName", Person.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new Person();
		} 
	}

	@Override
	public Person findById(Integer id) {
		try {
			return entityManager.createNamedQuery("Person.findPersonById", Person.class).setParameter("idPerson", id).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new Person();
		}
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		try {
        	Query query = entityManager.createNamedQuery("Person.deletePersonById").setParameter("idPerson", id);
            query.executeUpdate(); 
        } catch (ConstraintViolationException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
        	entityManager.close();
        }
	}
	
	public PagedSearchDTO<Person> pagedSearch(PagedSearchDTO<Person> person) {
		try {
			return personPagedSearchRepository.getPagedSearch("p", "Person", person);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
    }
}