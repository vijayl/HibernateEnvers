package com.vijayl.enverstest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vijayl.enverstest.dao.EmployeeDAO;
import com.vijayl.enverstest.entity.Employee;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
	
	@Autowired
    private EmployeeDAO employeeDAO;

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Transactional
	public List<Number> getAllEmployeeRevisions(Integer employeeId) {
		return employeeDAO.getAllEmployeeRevisions(employeeId);
	}
	
	@Transactional
	public Employee viewEmployee(Integer employeeId) {
		return employeeDAO.viewEmployee(employeeId);
	}
	
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
	
	@Transactional
	public Employee getEmployeeRevision(Integer employeeId, Integer revision){
		return employeeDAO.getEmployeeRevision(employeeId,revision);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
