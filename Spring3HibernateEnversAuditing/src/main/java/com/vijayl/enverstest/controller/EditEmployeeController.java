package com.vijayl.enverstest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vijayl.enverstest.entity.Address;
import com.vijayl.enverstest.entity.Employee;
import com.vijayl.enverstest.entity.Project;
import com.vijayl.enverstest.service.EmployeeManager;

@Controller
public class EditEmployeeController {
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) 
	{
		map.addAttribute("employee", new Employee());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());
		
		return "editEmployeeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") Employee employee, BindingResult result) 
	{
		
		Address a1 = new Address();
		a1.setCity("boston");
		a1.setStreet("main st");
		a1.setZip("09232");
		employee.getAddresses().add(a1);
		a1.getEmployees().add(employee);
		
		
		Project p1 = new Project();
		p1.setName("boston Project");
		p1.setDesc("default Project");
	
		employee.getProjects().add(p1);
		p1.setEmployee(employee);
		
		employeeManager.addEmployee(employee);
			
		return "redirect:/";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
	{
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/";
	}
	
	@RequestMapping("/view/{employeeId}")
	public String viewEmployee(@PathVariable("employeeId") Integer employeeId, ModelMap map)
	{
		Employee employee = employeeManager.viewEmployee(employeeId);
		
		map.addAttribute("employee", employee);
		return "employee";
	}
	
	@RequestMapping(value = "view/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute(value="employee") Employee employee, BindingResult result) 
	{
		employeeManager.updateEmployee(employee);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/showAddProject/{employeeId}", method = RequestMethod.GET)
	public String showAddProject(@PathVariable("employeeId") Integer employeeId, ModelMap map) 
	{
		map.addAttribute("employeeId", employeeId);
		map.addAttribute("project", new Project());
		return "project";
	}
	
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addAddress(@RequestParam("employeeId") Integer employeeId,@ModelAttribute(value="project") Project project, BindingResult result) 
	{
		Employee employee = employeeManager.viewEmployee(employeeId);
		
		project.setEmployee(employee);
		employee.getProjects().add(project);
		
		
		employeeManager.updateEmployee(employee);
		return "redirect:/";
	}


	@RequestMapping(value = "/showAddAddress/{employeeId}", method = RequestMethod.GET)
	public String showAddAddress(@PathVariable("employeeId") Integer employeeId, ModelMap map) 
	{
		map.addAttribute("employeeId", employeeId);
		map.addAttribute("address", new Address());
		return "address";
	}
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public String addAddress(@RequestParam("employeeId") Integer employeeId,@ModelAttribute(value="address") Address address, BindingResult result) 
	{
		Employee employee = employeeManager.viewEmployee(employeeId);
		
		address.getEmployees().add(employee);
		employee.getAddresses().add(address);
		
		
		employeeManager.updateEmployee(employee);
		return "redirect:/";
	}
	
	@RequestMapping("/getRevisions/{employeeId}")
	public String getRevisionsEmplyee(@PathVariable("employeeId") Integer employeeId, ModelMap map)
	{
		List<Number> revisions = employeeManager.getAllEmployeeRevisions(employeeId);
		
		for ( Number i: revisions )
			System.out.println("Revision : " + i);
		
		map.addAttribute("employeeId", employeeId);
		map.addAttribute("revisionList", revisions);
		
		return "revision";
	}
	
	@RequestMapping("/getRevision/{revisionId}")
	public String getRevision(@PathVariable("revisionId") Integer revisionId, @RequestParam("employeeId") Integer employeeId, ModelMap map)
	{
		Employee employee = employeeManager.getEmployeeRevision(employeeId, revisionId);
		
		map.addAttribute("employee", employee);
		return "employee";
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
}
