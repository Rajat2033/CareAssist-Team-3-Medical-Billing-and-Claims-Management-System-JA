package com.hexaware.medicalbillingsystem.dto;
/*
@Author:Hema sree
Date:15-11-2023
Description:DTO class for AdminMadical performing the following properties
*/	
public class AdminMedicalDTO {
	private int adminId;
	private String adminName;
	private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	

}
