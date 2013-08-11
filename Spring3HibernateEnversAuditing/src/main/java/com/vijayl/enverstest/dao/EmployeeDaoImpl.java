package com.vijayl.enverstest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vijayl.enverstest.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) this.sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
	}
	
	public void updateEmployee(Employee employee) {
		
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().saveOrUpdate(employee);;
        }
	}
	
	public Employee viewEmployee(Integer employeeId) {
		Employee employee = (Employee) this.sessionFactory.getCurrentSession().get(
				Employee.class, employeeId);
        return employee;
	}
	
	public List<Number> getAllEmployeeRevisions(Integer employeeId){
		
		AuditReader reader = AuditReaderFactory.get(this.sessionFactory.getCurrentSession());
		return reader.getRevisions(Employee.class, employeeId);
	}
	
	public Employee getEmployeeRevision(Integer employeeId, Integer revision){
		
		AuditReader reader = AuditReaderFactory.get(this.sessionFactory.getCurrentSession());
		Employee employee = reader.find(Employee.class, employeeId,revision);
		System.out.println(employee.getAddresses().size());
		
		return employee;
	}
	

}
