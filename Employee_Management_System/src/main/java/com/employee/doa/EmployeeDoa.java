package com.employee.doa;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.model.Employee;

public class EmployeeDoa {
	public void insertEmployee(Employee employee) {
    
	
		try {
		ResourceBundle rb = ResourceBundle.getBundle("oracle");
	    	    
		    	Configuration cfg = new Configuration();
		    	cfg.configure("hibernate.cfg.xml");
	            cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
	            cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
	            cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
	            
	            SessionFactory fact = cfg.buildSessionFactory();
				Session session = fact.openSession();
				Transaction t = session.beginTransaction();
				
				
				session.save(employee);
				t.commit();

				System.out.println("successfully saved");
				session.close();
				fact.close();
		
		}	
		catch(Exception exception) {
			
		exception.printStackTrace();
}
	}
	public Employee findEmployee(int id) {
		
			ResourceBundle rb = ResourceBundle.getBundle("oracle");
		    	    
			    	Configuration cfg = new Configuration();
			    	cfg.configure("hibernate.cfg.xml");
		            cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		            cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
		            cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
		            
		            SessionFactory fact = cfg.buildSessionFactory();
					Session session = fact.openSession();
					Transaction t = session.beginTransaction();
					Query selectQuery = (Query) session.createQuery("select obj from Employee obj where obj.id =:id");
					selectQuery.setParameter("id", id);
					 List resultset  =  ((org.hibernate.Query) selectQuery).list();
					if(resultset.size()==0) {
						throw new EmployeeNotFoundException("Employee Not Available");
					}
					return (Employee) resultset.get(0);

		


}
}


