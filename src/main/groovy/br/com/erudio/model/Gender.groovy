package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="gender")
@EqualsAndHashCode(includes = 'idGender')
class Gender implements Serializable {
    
    private static final long serialVersionUID =  1L;   
    
    @Id
    @GeneratedValue
    @Column(name="IdGender",nullable=false)
    Integer idGender;
    
    @Column(name="Description", unique=true, nullable=false, length=9)
    String description;

    Gender() {}
}