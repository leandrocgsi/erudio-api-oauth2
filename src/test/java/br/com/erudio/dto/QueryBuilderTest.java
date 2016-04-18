package br.com.erudio.dto;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.model.Person;
import br.com.erudio.repository.querybuilder.QueryBuilder;

public class QueryBuilderTest {
    
    PagedSearchDTO<Person> dto = new PagedSearchDTO<Person>();
    QueryBuilder<Person> queryBuilder = new QueryBuilder<Person>();
    
    @Before
    public void setup() {
        dto = mockDTO();    
    }
    
    @Test
    public void getBaseSelectTest() {
        String baseSelect = "select p from Person p ";
        assertEquals(baseSelect, queryBuilder.withDTO(dto).getBaseSelect("p", "Person"));
    }
    
    @Test
    public void getStartTest() {
        assertEquals((Integer)0, queryBuilder.withDTO(dto).getStart());
    }
    
    @Test
    public void getBaseSelectCount() {
        String baseSelect = "select count(*) from Person p ";
        assertEquals(baseSelect, queryBuilder.withDTO(dto).getBaseSelectCount("p", "Person"));
    }
    
    @Test
    public void getWhereAndParametersTest() {
        String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
        assertEquals(whereClause, queryBuilder.withDTO(dto).getWhereAndParameters("p"));
    }
    
    @Test
    public void getWhereAndParametersWithBlankStringKeyTest() {
        Map<String, Object> filters = mockFilters();
        filters.put("", "LEANDRO");
        dto.setFilters(filters);
        String whereClause = " where p.phone = :phone and p.name = :name and p.email = :email and 1 = 1 ";
        assertEquals(whereClause, queryBuilder.withDTO(dto).getWhereAndParameters("p"));
    }

    @Test
    public void getWhereAndParametersWithBlankStringValueTest() {
        Map<String, Object> filters = new HashMap<String, Object>();
        filters.put("name", "");
        dto.setFilters(filters);
        String whereClause = " where 1 = 1 ";
        assertEquals(whereClause, queryBuilder.withDTO(dto).getWhereAndParameters("p"));
    }
    
    @Test
    public void getHQLQueryTest() {
        String selectWithParameters = "select p from Person p"
                + "  where p.phone = :phone and"
                + " p.name = :name and"
                + " p.email = :email and 1 = 1 "
                + " order by p.name asc";
        assertEquals(selectWithParameters, queryBuilder.withDTO(dto).getHQLQuery("p", "Person"));
    }
    
    @Test
    public void getHQLQueryTestWithDTOFromJSON() {
        String selectWithParameters = "select p from Person p"
                + "  where 1 = 1 "
                + " order by p.name asc";
        assertEquals(selectWithParameters, queryBuilder.withDTO(mockDTOFromJSON()).getHQLQuery("p", "Person"));
    }
    
    @Test
    public void getOrderByTest() {
        assertEquals(" order by p.name asc", queryBuilder.withDTO(dto).getOrderBy("p"));
    }
    
    @SuppressWarnings("unchecked")
    public PagedSearchDTO<Person> mockDTOFromJSON(){
        PagedSearchDTO<Person> dtoFromJSON = new PagedSearchDTO<Person>();
        try {
            dtoFromJSON = new ObjectMapper().readValue(PagedSearchDTOMock.PAGED_SEARCH_DTO_JSON, PagedSearchDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dtoFromJSON;
    }
    
    public PagedSearchDTO<Person> mockDTO(){
        dto.setCurrentPage(1);
        dto.setPageSize(10);
        dto.setSortFields("name");
        dto.setSortDirections("asc");
        dto.setFilters(mockFilters());
        return dto;
    }

    private Map<String, Object> mockFilters() {
        Map<String, Object> filters = new HashMap<String, Object>();
        filters.put("name", "LEANDRO");
        filters.put("email", "a@b.c");
        filters.put("phone", "12345678998");
        filters.put("cpf", null);
        filters.put("religion", null);
        filters.put("cpf", null);
        filters.put(null, "COSTA");
        return filters;
    }
}