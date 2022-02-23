package com.employee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;

public class EmployeeDAO {
	
	public List<Employee> findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query selectQuery = session.createQuery("select obj from Employee obj where obj.id =:au");
		selectQuery.setParameter("au", id);
		List<Employee> resultset = selectQuery.list();
		session.close();
		if(resultset.size()==0) {
			throw new EmployeeNotFoundException("Employee Not present");
		}
		return resultset;
	}
	
	public void saveEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		t.commit();
		System.out.println("inserted");
		session.close();
	}
	
	public void deleteEmployeeById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query deleteQuery =  session.createQuery("DELETE FROM Employee it  where it.id =:ide");
		deleteQuery.setParameter("ide",id);
		t.commit();
        System.out.println("successfully deleted");
		session.close();
	 
 }

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	

}
