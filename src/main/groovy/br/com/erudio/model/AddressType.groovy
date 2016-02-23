package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="address_type")
@EqualsAndHashCode(includes = 'idAddressType')
class AddressType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdAddressType", nullable = false)
    Integer idAddressType;
    
    @Column(name = "Description", nullable = false, length = 35)
    String description;

    AddressType() {}
}