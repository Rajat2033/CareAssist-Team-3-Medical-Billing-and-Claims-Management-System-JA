package com.hexaware.medicalbillingsystem.dto;
/*
@Author :  Hema Sree  
Modified Date : 06-11-2023
Description :DTO class for InsuranceCompany containing various properties
*/

public class InsuranceCompanyDTO {
	private int companyId;
	private String companyName;
	private String companyPassword;
	private String companyEmail;
	private String companyContact;
	private String companyStartYears;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyStartYears() {
		return companyStartYears;
	}

	public void setCompanyStartYears(String companyStartYears) {
		this.companyStartYears = companyStartYears;
	}

}
