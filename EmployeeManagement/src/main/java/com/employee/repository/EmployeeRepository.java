package com.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;



@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Long>{
	List<Employee> findByGenderAndAgeGreaterThanAndAgeLessThan(String gender,int  minage, int maxAge);
	List<Employee> findByGender(String gender);
	List<Employee> findByAgeGreaterThanAndAgeLessThan(int  minage, int maxage);
}
