package com.springboot.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.crudapp.bean.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManager entityManager;

	@Override	
	public List<Employee> findAll() {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		// create the query
		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);
		// execute the query and get result list
		List<Employee> result = theQuery.getResultList();
		// return the result
		return result;		
	}

	@Override
	public void save(Employee emp) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);	
		// save the employee 
		session.saveOrUpdate(emp); // If id=0 then save/insert else update
	}

	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		// get the employee
		Employee emp = session.get(Employee.class, id);
		// return the employee
		return emp;
	}

	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);	
		// delete object with primary key
		Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
	}

}
