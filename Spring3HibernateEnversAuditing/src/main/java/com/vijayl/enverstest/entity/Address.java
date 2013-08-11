package com.vijayl.enverstest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;


@Entity
@Table(name="ADDRESS")

@Audited
@AuditTable(value = "ADDRESS_HISTORY")
public class Address {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Long id;

    @Column(name="STREET")
    private String street;
    
    @Column(name="ZIP")
    private String zip;
    
    @Column(name="CITY")
    private String city;

    @ManyToMany(mappedBy="addresses")
    @Fetch(FetchMode.JOIN)
    @Cascade ( { org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Employee> employees = new HashSet<Employee>(0);
    
    
    
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Address() {
    }

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
