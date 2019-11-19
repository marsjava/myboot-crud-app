package com.springboot.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapp.bean.Employee;
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
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theEmployee.setId(0);
		service.save(theEmployee);
		return theEmployee;
	}
	// add mapping for put /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		service.save(theEmployee);
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = service.findById(employeeId);
		// throw exception if null
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		service.deleteById(employeeId);
		return "Deleted employee id - "+employeeId;
	}
	
}
