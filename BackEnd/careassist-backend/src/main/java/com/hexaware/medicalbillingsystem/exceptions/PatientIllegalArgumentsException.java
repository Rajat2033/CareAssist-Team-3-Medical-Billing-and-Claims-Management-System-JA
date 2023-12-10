package com.hexaware.medicalbillingsystem.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
/*
@Author :   Hema Sree 
Modified Date : 15-10-2023
Description : Getting the exception of PatientIIlegalArgumentException
*/
public class PatientIllegalArgumentsException extends ResponseStatusException {

	
	private static final long serialVersionUID = 1L;

	public PatientIllegalArgumentsException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

	

}
