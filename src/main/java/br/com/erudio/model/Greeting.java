package br.com.erudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
@NamedQuery(name = Greeting.FIND_BY_ID, query = "select a from Greeting a where a.id = :id")
public class Greeting implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_ID = "Greeting.findById";
	
	@Id
	@GeneratedValue
	private final Long id;
	
	@Column
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
