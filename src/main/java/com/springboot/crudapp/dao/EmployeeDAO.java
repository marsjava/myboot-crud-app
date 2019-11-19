package com.springboot.crudapp.dao;

import java.util.List;

import com.springboot.crudapp.bean.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public void save(Employee emp);
	public Employee findById(int id);
	public void deleteById(int id);
}
