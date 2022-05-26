package com.spring.rest.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.crud.dao.exception.EmployeeNotFoundException;
import com.spring.rest.crud.entity.Employee;
import com.spring.rest.crud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Find Employee by ID
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	// Get All Employee list
	@RequestMapping(value = "/getAllEmps", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getEmployees() {

		List listOfEmps = employeeService.getAllEmployees();
		return listOfEmps;
	}

	// Add Employee
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);

	}

	// Update Employee
	@RequestMapping(value = "/updateEmp", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
	}

	@RequestMapping(value = "/deleteEmp/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}
}
