package br.com.erudio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name = "greeting")
@EqualsAndHashCode
class Greeting implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	final Long id;
	
	@Column
    final String content;

    Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    long getId() {
        return id;
    }

    String getContent() {
        return content;
    }
}
