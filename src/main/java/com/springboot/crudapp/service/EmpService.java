package com.springboot.crudapp.service;

import java.util.List;

import com.springboot.crudapp.bean.Employee;

public interface EmpService {
	public List<Employee> findAll();
	public void save(Employee emp);
	public Employee findById(int id);
	public void deleteById(int id);
}
