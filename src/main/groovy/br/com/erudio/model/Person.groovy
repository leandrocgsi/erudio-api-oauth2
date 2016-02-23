package br.com.erudio.model;

import groovy.transform.EqualsAndHashCode

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Temporal

import org.hibernate.annotations.ForeignKey


@SuppressWarnings("deprecation")
@Entity
@Table (name="person")
@EqualsAndHashCode(includes = 'idPerson')
class Person implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdPerson", nullable=false)
    Integer idPerson;
    
    @Column (name="Name", nullable = false, length = 80 )
    String name;
    
    @Column (name="Email", nullable = false, length = 80 )
    String email;
    
    @Column (name="Phone", nullable = false, length = 16 )//(034)-98888-8888
    String phone;
    
    @Column (name="CPF", nullable = false, length = 14 )
    String cpf;
    
    @Column (name="BirthDayDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date birthDayDate;
    
    @Column (name="InsertDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date insertDate;
    
        
    @Column(name = "Login", unique=true, length = 25)
    String login;
    
    @Column(name = "Password", length = 40)
    String password;
    
    @Column(name = "Permission", length = 36)
    String permission;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "PersonGender") 
    @JoinColumn(name="IdGender", referencedColumnName = "IdGender")
    Gender gender;
	
	@ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ForeignKey(name="PersonPersonAddress")
	@JoinTable(name="person_address", joinColumns=@JoinColumn(name="IdPerson"), inverseJoinColumns=@JoinColumn(name="IdAddress"))
	List<Address> addresses;

    Person() {
        this.gender = new Gender();
    }  
}