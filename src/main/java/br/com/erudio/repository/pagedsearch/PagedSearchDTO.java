package br.com.erudio.repository.pagedsearch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

public class PagedSearchDTO<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalResults;
	private String sortFields;
	private String sortDirections;
	private Map<String, Object> filters = new HashMap<>();
	private List<T> list;

	public PagedSearchDTO() {}

	public PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
	}

	public PagedSearchDTO(Integer currentPage, Integer pageSize, String sortFields, String sortDirections, Map<String, Object> filters) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.sortFields = sortFields;
		this.sortDirections = sortDirections;
		this.filters = filters;
	}

	public PagedSearchDTO(Integer currentPage, String sortFields, String sortDirections) {
		this(currentPage, Integer.valueOf(10), sortFields, sortDirections);
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public String getSortFields() {
		return sortFields;
	}

	public void setSortFields(String sortFields) {
		this.sortFields = sortFields;
	}

	public String getSortDirections() {
		return sortDirections;
	}

	public void setSortDirections(String sortDirections) {
		this.sortDirections = sortDirections;
	}

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getStart() {
		return Integer.valueOf((getCurrentPage().intValue() - 1) * getPageSize().intValue());
	}
	
	public String getOrderBy(String alias) {
		return " order by " + alias + "." + "sortFields" + " " + "sortDirections";
	}
	
	public String getParameters(String alias) {
			String query = " where ";
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				if (!StringUtils.isEmpty(entry.getKey()) && !StringUtils.isEmpty(entry.getValue().toString())) {
					String key = entry.getKey();
					query = query + alias + "." + key + " = " + key + " and ";
				}
			}
			return query;
		}
		
	public void setFiltersParameters(Query query, PagedSearchDTO<T> person) {
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				if (!StringUtils.isEmpty(entry.getKey()) && !StringUtils.isEmpty(entry.getValue().toString())) {
					String key = entry.getKey();
					String value = entry.getValue().toString();
					query.setParameter(key, value);
				}
			}
		}
}