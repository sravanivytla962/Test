package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.pojo.Credentials;

@Repository
public interface UserRepository extends CrudRepository<Credentials, Long>{
	Credentials findByUsername(String username);
}
