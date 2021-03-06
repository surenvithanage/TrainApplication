package com.ds.trainapplication.mapping;
// Generated Apr 8, 2019 9:29:15 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ds.trainapplication.bean.AbstractTimestampEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,catalog="trainapplication"
)
public class Customer  extends AbstractTimestampEntity  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 227675114628471149L;
	/**
	 * 
	 */
	
	private Integer id;
     private String firstName;
     private String lastName;
     private Integer age;
     private String address;
     private String phonenumber;
     private String email;
     private Set<Reservation> reservations = new HashSet<Reservation>(0);

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer age, String address, String phonenumber, String email, Set<Reservation> reservations) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
       this.address = address;
       this.phonenumber = phonenumber;
       this.email = email;
       this.reservations = reservations;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="first_name")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="age")
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    
    @Column(name="address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="phonenumber")
    public String getPhonenumber() {
        return this.phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	@JsonManagedReference
	public Set<Reservation> getReservations() {
        return this.reservations;
    }
    
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }




}


