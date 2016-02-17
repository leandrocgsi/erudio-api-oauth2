package br.com.erudio.repository.generic;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class GenericRepository<T> implements IGenericRepository<T>, Serializable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> clazz;
	
    public GenericRepository() { }

	public GenericRepository(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    @Transactional
    public T save(T entity) {
    	try {
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
    }

    @Override
    @Transactional
    public T update(T entity) {
    	try {
			return entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
    }

    @Override
    @Transactional
    public Boolean delete(T entity) {
		try {
			entityManager.remove(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
    }

    @Override
    @Transactional
    public T merge(T entity) {
    	try {
			return entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
    }

    @Override
    @Transactional
    public T getEntity(Serializable id) {
        try {
	        T entity = (T)entityManager.getReference(clazz, id);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

//    @Override
//    T getEntityByDetachedCriteria(DetachedCriteria criteria) {
//        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
//        return entity;
//    }
        
	@Override
	public T getEntityByHQLQuery(String stringQuery) {
        try {
	        Query query = entityManager.createQuery(stringQuery);        
			return (T) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

//    @Override
//    List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
//        return criteria.getExecutableCriteria(session).list();
//    }
//    
//    @Override
//    List<T> getEntities() {
//        List<T> enties = (List<T>) entityManager.createQuery(clazz).list();
//        return enties;
//    }    
    
}
