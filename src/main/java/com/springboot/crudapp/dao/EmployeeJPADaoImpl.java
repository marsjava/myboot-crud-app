package com.springboot.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.crudapp.bean.Employee;
@Repository
public class EmployeeJPADaoImpl implements EmployeeDAO {
	@Autowired
	private EntityManager em;
	@Override
	public List<Employee> findAll() {
		Query theQuery = em.createQuery("from Employee");
		List<Employee> empList = theQuery.getResultList();
		return empList;
	}

	@Override
	public void save(Employee emp) {
		// save or update the employee
		Employee theEmployee = em.merge(emp);
		// update with id from db ... so we can get generate id for save/insert
		emp.setId(theEmployee.getId());

	}

	@Override
	public Employee findById(int id) {
		Employee employee = em.find(Employee.class, id);
		return employee;
	}

	@Override
	public void deleteById(int empId) {
		// delete object with primary key
		Query theQuery = em.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", empId);
		theQuery.executeUpdate();
	}

}
