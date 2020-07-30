package com.employee.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException{
		Optional<Employee> employeeList = employeeRepository.findById(employee.getId());
		if (employeeList.isPresent()) {
			throw new EmployeeNotFoundException("Employee with id " + employee.getId() + "alreadyexists");
			}

		Employee emp = employeeRepository.save(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(emp.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	

	@GetMapping("/employees/{gender}/{minage}/{maxage}")
	public List<Employee> getEmployee(@PathVariable String gender,@PathVariable int minage, @PathVariable int maxage) throws EmployeeNotFoundException {
		List<Employee> employee =employeeRepository.findByGenderAndAgeGreaterThanAndAgeLessThan(gender,minage, maxage);

		if (null != employee && employee.isEmpty()) {
					throw new EmployeeNotFoundException("No employee found with this search criteria");
	   }

		return employee;
	}
	
	@GetMapping("/employees")
	public List<Employee> retrieveStudent(@RequestParam(name="gender") String gender,
			@RequestParam(name="minage",defaultValue = "0") int minage ,@RequestParam(name="maxage",defaultValue = "0") int maxage) throws EmployeeNotFoundException {
		List<Employee> emplist = null;
		if(gender ==null && minage == 0 && maxage == 0) {
			 emplist = (List<Employee>) employeeRepository.findAll();
		} else if(gender !=null && minage == 0 && maxage == 0) {
			emplist = employeeRepository.findByGender(gender);
		} else if(gender ==null && minage != 0 && maxage != 0){
			emplist =employeeRepository.findByAgeGreaterThanAndAgeLessThan(minage,maxage);
		}else {
			emplist =employeeRepository.findByGenderAndAgeGreaterThanAndAgeLessThan(gender,minage, maxage);
		}
		if (null != emplist && emplist.isEmpty()) {
					throw new EmployeeNotFoundException("No employee found with this search criteria");
	   }

		return emplist;
	}
	

}

