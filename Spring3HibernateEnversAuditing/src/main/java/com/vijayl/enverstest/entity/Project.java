package com.vijayl.enverstest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "PROJECT")
@Audited
@AuditTable(value = "PROJECT_HISTORY")
public class Project {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "PROJNAME")
	private String name;

	@Column(name = "PROJDESC")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID", nullable=false)
    @Fetch(FetchMode.JOIN)
    @Cascade ( { org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Employee employee;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project() {
		
	}
	
	
	

}
