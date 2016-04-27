package br.com.erudio.repository.generic;

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query

import org.apache.log4j.Logger
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
public class GenericRepository<T> implements IGenericRepository<T>, Serializable {

    private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(GenericRepository.class);
    
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
			logger.info("Persisting an entity");
			return entityManager.merge(entity);
		} catch (Exception e) {
			logger.error(e);
		}
    }

    @Override
    @Transactional
    T update(T entity) {
    	try {
			logger.info("Updating an entity");
			return entityManager.merge(entity);
		} catch (Exception e) {
			logger.error(e);
		}
    }

    @Override
    @Transactional
    Boolean delete(T entity) {
		try {
			logger.info("Removing an entity");
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
			logger.info("Persisting an entity");
			return entityManager.merge(entity);
		} catch (Exception e) {
			logger.error(e);
		}
    }

    @Override
    @Transactional
    T getEntity(Serializable id) {
        try {
			logger.info("Finding an entity");
	        T entity = (T)entityManager.getReference(clazz, id);
			return entity;
		} catch (Exception e) {
			logger.error(e);
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
			logger.info("Finding an entity with HQL");
	        Query query = entityManager.createQuery(stringQuery);        
			return (T) query.getSingleResult();
		} catch (Exception e) {
			logger.error(e);
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
