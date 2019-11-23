package com.springboot.crudapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.crudapp.bean.Employee;
import com.springboot.crudapp.dao.EmployeeDAO;
@Service
@Transactional
public class EmployeeService implements EmpService{
	@Autowired	
	@Qualifier("employeeJPADaoImpl")
	private EmployeeDAO employeeDao;
//	public EmployeeService(EmployeeDAO theEmployeeDao) {
//		employeeDao = theEmployeeDao;
//	}
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void save(Employee emp) {
		employeeDao.save(emp);		
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);		
	}

}
