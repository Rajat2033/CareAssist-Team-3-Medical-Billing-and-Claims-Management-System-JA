package com.hexaware.medicalbillingsystem.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
/*
@Author : Hema Sree 
Modified Date : 16-10-2023
Description : Getting the exception of PatientNotFoundException
*/
public class PatientNotFoundException extends ResponseStatusException{

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

}
