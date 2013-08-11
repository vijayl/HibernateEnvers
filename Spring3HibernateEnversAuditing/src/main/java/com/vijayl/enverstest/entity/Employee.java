package com.vijayl.enverstest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.sun.istack.internal.Nullable;


@Entity
@Table(name="EMPLOYEE")
@Audited
@AuditTable(value = "EMPLOYEE_HISTORY")
public class Employee {
     
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
     
    @Column(name="FIRSTNAME")
    private String firstname;
 
    @Column(name="LASTNAME")
    private String lastname;
 
    @Column(name="EMAIL")
    private String email;
     
    @Column(name="TELEPHONE")
    private String telephone;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name="EMP_ADDRESS" , 
                joinColumns= {@JoinColumn(name="EMP_ID") },
                inverseJoinColumns= { @JoinColumn(name="ADDRESS_ID") })
    @Fetch(FetchMode.JOIN)
    @Nullable
    @Cascade ( { org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @AuditJoinTable(name="EMP_ADDRESS_HISTORY") 
    private Set<Address> addresses = new HashSet<Address>(0);
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="employee" )
    @Cascade ( { org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    @Nullable
    private Set<Project> projects = new HashSet<Project>(0);
     
    
    public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}