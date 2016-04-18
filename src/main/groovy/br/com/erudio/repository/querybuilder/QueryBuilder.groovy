package br.com.erudio.repository.querybuilder;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Repository

import br.com.erudio.dto.PagedSearchDTO;

@Repository
public class QueryBuilder<T extends Serializable> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private PagedSearchDTO<T> pagedSearchDTO = new PagedSearchDTO<T>();
    
    public QueryBuilder<T> withDTO(PagedSearchDTO<T> pagedSearchVO) {
        this.pagedSearchDTO = pagedSearchVO;
        return this;
    }
    
    String getOrderBy(String alias) {
        " order by ${alias}.${pagedSearchDTO.sortFields} ${pagedSearchDTO.sortDirections}";
    }
    
    String getWhereAndParameters(String alias) {
        def query = ' where ';
        pagedSearchDTO.filters.each{ k, v -> (isEmpty(k, v)) ? query = query + "${alias}.${k} = :${k} and " : "" }
        query + '1 = 1 ';
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
    
    Integer getStart() {
        Integer.valueOf((pagedSearchDTO.getCurrentPage() - 1.intValue()) * pagedSearchDTO.getPageSize());
    }
}