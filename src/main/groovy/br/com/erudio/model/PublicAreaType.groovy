package br.com.erudio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name="public_area_type")
@EqualsAndHashCode(includes = 'idPublicAreaType')
class PublicAreaType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue
    @Column(name = "IdPublicAreaType", nullable = false)
    Integer idPublicAreaType;
    
    @Column(name = "PublicAreaTypeDescription", nullable = false, length = 40)
    String publicAreaTypeDescription;

    PublicAreaType() {}
}