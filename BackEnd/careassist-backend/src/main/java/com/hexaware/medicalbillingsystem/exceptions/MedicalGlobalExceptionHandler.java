package com.hexaware.medicalbillingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
@Author : Rajat Darvhekar  
Modified Date : 15-10-2023
Description : Getting the exception of MedicalExceptionHandler
*/

@RestControllerAdvice
public class MedicalGlobalExceptionHandler {

	@ResponseStatus
	@ExceptionHandler({ PatientNotFoundException.class, PatientIllegalArgumentsException.class,
			PlanNotFoundException.class, NoSuchInvoiceGeneratedException.class, ClaimNotValidException.class,
			CompanyNotRegisteredException.class,UsernameNotFoundException.class })
	public ResponseEntity<String> handleAnyException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
