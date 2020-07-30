package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.util.CommonUtil;



@ControllerAdvice
@RestController
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(UserNotFoundException.class)
	    public final ResponseEntity<Object> resourceNotFound(UserNotFoundException ex, WebRequest request) throws Exception {
	        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),203,CommonUtil.getCurrentDateTime());
	        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(EmployeeNotFoundException.class)
	    public final ResponseEntity<Object> emloyeeNotFound(EmployeeNotFoundException ex, WebRequest request) throws Exception {
	        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),203,CommonUtil.getCurrentDateTime());
	        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	    }
}
