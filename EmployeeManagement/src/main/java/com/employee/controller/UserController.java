package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.UserNotFoundException;
import com.employee.model.User;
import com.employee.repository.UserRepository;



@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	  @PostMapping("/login")
	    public ResponseEntity<User> getUser(@RequestBody User user) throws Exception {
	        User userdetails = userRepository.findByUsernameAndPassword(user.getUsername(),
	        		user.getPassword());
	        if(userdetails == null) {
	            throw new UserNotFoundException("User is not found Enter valid credential");
	        }
	        return new ResponseEntity<User>(HttpStatus.OK);
	    }

}
