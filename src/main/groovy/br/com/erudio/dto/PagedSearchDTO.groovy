package br.com.erudio.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

}