package br.com.erudio.model;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

import br.com.erudio.model.State;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="state")
@EqualsAndHashCode(includes = 'idState')
class State implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdState", nullable = false)
    Integer idState;
    @Column(name = "StateName", nullable = false, length = 40)
    String stateName;

    State() {}
}