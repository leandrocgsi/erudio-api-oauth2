package br.com.erudio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.ForeignKey;


@SuppressWarnings("deprecation")
@Entity
@Table (name="person")
@NamedQueries(
		{@NamedQuery(name = Person.FIND_BY_NAME, query = "select p from Person p where p.name = :name"),
		 @NamedQuery(name = Person.FIND_ALL_PERSONS, query = "select p from Person p"),
		 @NamedQuery(name = Person.DELETE_BY_ID, query = "delete from Person where idPerson = :idPerson"),
		 @NamedQuery(name = Person.FIND_BY_ID, query = "select p from Person p where p.idPerson = :idPerson")})
public class Person implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    public static final String FIND_BY_ID = "Person.findPersonById";
    public static final String FIND_BY_NAME = "Person.findPersonByName";
    public static final String FIND_ALL_PERSONS = "Person.findAllPersons";
    public static final String DELETE_BY_ID = "Person.deletePersonById";
    
    @Id
    @GeneratedValue
    @Column(name="IdPerson", nullable=false)
    private Integer idPerson;
    
    @Column (name="Name", nullable = false, length = 80 )
    private String name;
    
    @Column (name="Email", nullable = false, length = 80 )
    private String email;
    
    @Column (name="Phone", nullable = false, length = 15 )//(034)-8888-8888
    private String phone;
    
    @Column (name="CPF", nullable = false, length = 14 )
    private String cpf;
    
    @Column (name="BirthDayDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDayDate;
    
    @Column (name="InsertDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insertDate;
    
        
    @Column(name = "Login", unique=true, length = 25)
    private String login;
    
    @Column(name = "Password", length = 40)
    private String password;
    
    @Column(name = "Permission", length = 36)
    private String permission;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @ForeignKey(name="PersonAddress")
    @JoinColumn(name="IdAddress", referencedColumnName = "IdAddress")
    private Address address;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "PersonGender") 
    @JoinColumn(name="IdGender", referencedColumnName = "IdGender")
    private Gender gender;

    public Person() {
        this.gender = new Gender();
    }

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDayDate() {
		return birthDayDate;
	}

	public void setBirthDayDate(Date birthDayDate) {
		this.birthDayDate = birthDayDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPerson == null) ? 0 : idPerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (idPerson == null) {
			if (other.idPerson != null)
				return false;
		} else if (!idPerson.equals(other.idPerson))
			return false;
		return true;
	}     
}