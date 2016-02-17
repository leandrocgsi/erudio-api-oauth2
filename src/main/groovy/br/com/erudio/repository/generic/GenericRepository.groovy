package br.com.erudio.repository.generic;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class GenericRepository<T> implements IGenericRepository<T>, Serializable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> clazz;
	
	GenericRepository() { }

	GenericRepository(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    @Transactional
    T save(T entity) {
    	try {
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace()
		}
		return entity;
    }

    @Override
    @Transactional
    T update(T entity) {
    	try {
			return entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace()
		}
    }

    @Override
    @Transactional
    Boolean delete(T entity) {
		try {
			entityManager.remove(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
    }

    @Override
    @Transactional
    T merge(T entity) {
    	try {
			return entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace()
		}
    }

    @Override
    @Transactional
    T getEntity(Serializable id) {
        try {
	        T entity = (T)entityManager.getReference(clazz, id);
			return entity;
		} catch (Exception e) {
			e.printStackTrace()
		}
    }

//    @Override
//    T getEntityByDetachedCriteria(DetachedCriteria criteria) {
//        T entity = (T)criteria.getExecutableCriteria(session).uniqueResult();
//        return entity;
//    }
        
	@Override
    T getEntityByHQLQuery(String stringQuery) {
        try {
	        Query query = entityManager.createQuery(stringQuery);        
			return (T) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace()
		}
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
