package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="city")
@EqualsAndHashCode(includes = 'idCity')
class City /*extends ResourceSupport*/ implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    @Id
    @GeneratedValue
    @Column(name="IdCity", nullable=false)
    Integer idCity;
    
    @Column(name="Name", length=80, nullable=false)
    String name;
    
    @JsonCreator
    City() {} 
}