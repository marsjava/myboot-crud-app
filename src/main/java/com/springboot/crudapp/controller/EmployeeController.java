package com.springboot.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapp.bean.Employee;
import com.springboot.crudapp.dao.EmployeeDAO;
import com.springboot.crudapp.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmpService service;
	@GetMapping("/")
	public String greetings() {
		return "Hi, Spring CRUD Operation.";
	}
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return service.findAll();
	}
	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		Employee empById = service.findById(id);
		if(empById == null) {
			throw new RuntimeException("Employee Id not found - "+id);
		}
		return empById;
	}
}
