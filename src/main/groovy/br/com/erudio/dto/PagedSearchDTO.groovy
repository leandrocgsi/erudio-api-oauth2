package br.com.erudio.dto

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query

import org.apache.commons.lang3.StringUtils


class PagedSearchDTO<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Integer currentPage;
	Integer pageSize;
	Integer totalResults;
	String sortFields;
	String sortDirections;
	Map<String, Object> filters;
	List<T> list;

	PagedSearchDTO() {}

	PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
	}

	PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections, Map<String, Object> filters) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
		this.filters = filters;
	}
	
	PagedSearchDTO(Integer currentPage, String sortFields, String sortDirections) {
		this(currentPage, Integer.valueOf(10), sortFields, sortDirections);
	}
	
	Integer getCurrentPage(){
		currentPage ?: 0;
	}
	
	Integer getPageSize(){
		pageSize ?: 0;
	}

	Integer getStart() {
		Integer.valueOf((getCurrentPage() - 1.intValue()) * getPageSize());
	}
	
	String getOrderBy(String alias) {
		" order by ${alias}.${sortFields} ${sortDirections}";
	}
	
	String getWhereAndParameters(String alias) {
		def query = ' where ';
		filters.each{ k, v -> (isEmpty(k, v)) ? query = query + "${alias}.${k} = :${k} and " : "" }
		query + '1 = 1 ';
	}
	
	void setParameters(Query query) {
		filters.each{ k, v -> (isEmpty(k, v)) ? query.setParameter("${k}", v) : ""}
	}
	
	
	Boolean isEmpty(String k, Object v) {
		k && v && !v.toString().empty;
	}
	
	String getHQLQuery(String alias, String entityName) {
		getBaseSelect(alias, entityName) + getWhereAndParameters(alias) + getOrderBy(alias);
	}

	String getBaseSelect(String alias, String entityName) {
		"select ${alias} from ${entityName} ${alias} ";
	}

	String getBaseSelectCount(String alias, String entityName) {
		"select count(*) from ${entityName} ${alias} ";
	}
	
	Long getTotal(EntityManager entityManager, String alias, String entityName) {
		String select = getBaseSelectCount(alias, entityName) + getWhereAndParameters(alias);
		Query query = entityManager.createQuery(select);
		setParameters(query);
		(Long)query.getSingleResult();
	}
	
	Query getSearchQuery(EntityManager entityManager, String alias, String entityName) {
		Query query = entityManager.createQuery(getHQLQuery(alias, entityName));
		setParameters(query);
		query.setFirstResult((getCurrentPage() - 1) * getPageSize());
		query.setMaxResults(getPageSize());
	}
	
	PagedSearchDTO<T> getPagedSearch(EntityManager entityManager, String alias, String entityName) {
		Query searchQuery = getSearchQuery(entityManager, alias, entityName);
		setList(searchQuery.getResultList());
		setTotalResults(getTotal(entityManager, alias, entityName).intValue());
		return this;
	}
}