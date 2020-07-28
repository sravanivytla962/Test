package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.pojo.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Long>{
	

}
