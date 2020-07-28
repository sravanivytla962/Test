package com.employee.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.pojo.Employee;
import com.employee.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp = employeeRepository.save(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(emp.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}
	
	@GetMapping("/getEmployees/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id){
		Optional<Employee> employeeList = employeeRepository.findById(id);
		return employeeList;
	}
}

