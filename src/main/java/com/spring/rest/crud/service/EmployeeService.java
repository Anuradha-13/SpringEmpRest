package com.spring.rest.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.crud.dao.EmployeeDAO;
import com.spring.rest.crud.entity.Employee;

@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;
	 
	    @Transactional
	    public Employee getEmployee(int id) {
	    	return employeeDAO.getEmployee(id);
	    }
	    
	    @Transactional
	    public List getAllEmployees() {
	        return employeeDAO.getAllEmployees();
	    }
	 
	 
	    @Transactional
	    public void addEmployee(Employee emp) {
	    	employeeDAO.addEmployee(emp);
	    }
	 
	    @Transactional
	    public void updateEmployee(Employee emp) {
	    	employeeDAO.updateEmployee(emp);
	 
	    }
	 
	    @Transactional
	    public void deleteEmployee(int id) {
	    	employeeDAO.deleteEmployee(id);
	    }
	}