package br.com.erudio.repository

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import br.com.erudio.dto.PagedSearchDTO
import br.com.erudio.model.Person
import br.com.erudio.repository.querybuilder.QueryBuilder

@Repository
@Transactional(readOnly = true)
class PersonPagedSearchRepository<T extends Serializable> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    QueryBuilder<Person> queryBuilder; 

    @PersistenceContext
    private EntityManager entityManager;

    void setParameters(Query query, Map<String, Object> filters) {
        filters.each{ k, v -> (isEmpty(k, v)) ? query.setParameter("${k}", v) : ""}
    }
    
    Boolean isEmpty(String k, Object v) {
        k && v && !v.toString().empty;
    }
    
    Long getTotal(String alias, String entityName, PagedSearchDTO<Person> person) {
        String select = queryBuilder.withDTO(person).getBaseSelectCount(alias, entityName) + queryBuilder.withDTO(person).getWhereAndParameters(alias);
        Query query = entityManager.createQuery(select);
        setParameters(query, person.getFilters());
        (Long)query.getSingleResult();
    }
    
    Query getSearchQuery(String alias, String entityName, PagedSearchDTO<Person> person) {
        String select = queryBuilder.withDTO(person).getHQLQuery(alias, entityName);
        Query query = entityManager.createQuery(select);
        setParameters(query, person.getFilters());
        query.setFirstResult((person.getCurrentPage() - 1) * person.getPageSize());
        query.setMaxResults(person.getPageSize());
        query;
    }
    
    PagedSearchDTO<Person> getPagedSearch(String alias, String entityName, PagedSearchDTO<Person> person) {
        Query searchQuery = getSearchQuery(alias, entityName, person);
        person.setList(searchQuery.getResultList());
        person.setTotalResults(getTotal(alias, entityName, person).intValue());
        (PagedSearchDTO<Person>) person;
    }
}