package com.employee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
import com.employee.model.EmployeeOperation;

public class EmployeeDAOImpl implements EmployeeDAO {
	Employee emp= new Employee();
	EmployeeOperation eo=new EmployeeOperation();
	@Autowired
	private SessionFactory sessionFactory;
	public void addEmployee(Employee employee) {
		
		eo.salaryOperation(emp.getBasicpay());
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}
	@Override
	public void deleteEmployee(Integer Id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, Id);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}
	public Employee getEmployee(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, id);
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		eo.salaryOperation(emp.getBasicpay());
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}
