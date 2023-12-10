package com.hexaware.medicalbillingsystem.dto;
/*
	@Author :  Rajat Darvehkar
	Modified Date : 06-11-2023
	Description :DTO class for AuthRequest containing various properties
	*/
public class AuthRequest {

	private String username;
	private String password;

	public AuthRequest() {
		super();

	}

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
