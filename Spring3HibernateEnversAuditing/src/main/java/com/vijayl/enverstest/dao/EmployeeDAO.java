package com.vijayl.enverstest.dao;

import java.util.List;

import com.vijayl.enverstest.entity.Employee;

public interface EmployeeDAO 
{
    public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
	public List<Number> getAllEmployeeRevisions(Integer employeeId);
	public Employee viewEmployee(Integer employeeId) ;
	public void updateEmployee(Employee employee) ;
	public Employee getEmployeeRevision(Integer employeeId, Integer revision);

}