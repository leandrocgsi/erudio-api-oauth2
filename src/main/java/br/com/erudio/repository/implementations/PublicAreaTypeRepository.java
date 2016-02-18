package br.com.erudio.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.model.PublicAreaType;
import br.com.erudio.repository.generic.GenericRepository;
import br.com.erudio.repository.interfaces.IPublicAreaTypeRepository;

@Repository
@Transactional(readOnly = true)
public class PublicAreaTypeRepository extends GenericRepository<PublicAreaType> implements IPublicAreaTypeRepository{

	private static final long serialVersionUID = 1L;

	public PublicAreaTypeRepository() {
		super(PublicAreaType.class);
	}
	
	@Override
	public PublicAreaType findById(Integer id) {
		try {
			return entityManager.createQuery("select p from PublicAreaType p where p.idPublicAreaType = :idPublicAreaType", PublicAreaType.class).setParameter("idPublicAreaType", id).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new PublicAreaType();
		}
	}
	
	public PublicAreaType findByName(String name) {
		try {
			return entityManager.createQuery("select p from PublicAreaType p where p.publicAreaTypeDescription like :name", PublicAreaType.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new PublicAreaType();
		} 
	}
	
	public List<PublicAreaType> findAll() {
		try {
			return entityManager.createQuery("select p from PublicAreaType p", PublicAreaType.class).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return new ArrayList<PublicAreaType>();
		}
	}
}