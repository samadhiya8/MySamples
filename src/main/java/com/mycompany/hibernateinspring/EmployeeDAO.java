/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateinspring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Samadhiya
 */

@Transactional
public class EmployeeDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void insertEmployee(Employee user) {
            Session s=sessionFactory.getCurrentSession();
            s.save(user);
	}
	
	public Employee getEmployeeById(int employeeId) {
            Session s=sessionFactory.getCurrentSession();
            return (Employee)s.get(Employee.class, employeeId);
        }
	public List<Employee> getEmployeeList() {
            System.out.println("In getEmployee list");
            Session s=sessionFactory.getCurrentSession();
            @SuppressWarnings("unchecked")
            List<Employee> empList=(List<Employee>)s.createQuery("FROM Employee").list();
            return empList;
        }

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
        
}
