package com.spring.rest.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.crud.dao.exception.EmployeeNotFoundException;
import com.spring.rest.crud.entity.Employee;

@Repository
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Employee getEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, new Integer(id));
		if(emp==null) {
			throw new EmployeeNotFoundException("Invalid Employee ID");
		}
		return emp;
	}

	public List getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List empList = session.createQuery("from Employee").list();
		return empList;
	}

	public Employee addEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(emp);
		return emp;
	}

	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);
	}

	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee existingEmp = (Employee) session.get(Employee.class, new Integer(id));
		if (null != existingEmp) {
			session.delete(existingEmp);
		}
		else throw new EmployeeNotFoundException("Employee does not exist");
	}

}
