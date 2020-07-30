package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
   User findByUsernameAndPassword(String username, String password);
}