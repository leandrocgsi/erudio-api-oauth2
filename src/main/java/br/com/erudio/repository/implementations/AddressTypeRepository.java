package br.com.erudio.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.AddressType;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.IAddressTypeRepository;

@Repository
@Transactional(readOnly = true)
public class AddressTypeRepository extends GenericRepository<AddressType> implements IAddressTypeRepository{

	private static final long serialVersionUID = 1L;

	public AddressTypeRepository() {
		super(AddressType.class);
	}
	
	@Override
	public AddressType findById(Integer id) {
		try {
			return entityManager.createQuery("select p from AddressType p where p.idAddressType = :idAddressType", AddressType.class).setParameter("idAddressType", id).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new AddressType();
		}
	}
	
	public AddressType findByName(String name) {
		try {
			return entityManager.createQuery("select p from AddressType p where p.description like :description", AddressType.class).setParameter("description", name).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new AddressType();
		} 
	}
	
	public List<AddressType> findAll() {
		try {
			return entityManager.createQuery("select p from AddressType p", AddressType.class).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new ArrayList<AddressType>();
		}
	}
}