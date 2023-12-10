package com.hexaware.medicalbillingsystem.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
/*
@Author : Rajat Darvhekar  
Modified Date : 15-10-2023
Description : Getting the exception of  CompanyNotRegisteredException 
*/
public class CompanyNotRegisteredException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public CompanyNotRegisteredException(HttpStatusCode status, String reason) {
		super(status, reason);
		
	}

}
