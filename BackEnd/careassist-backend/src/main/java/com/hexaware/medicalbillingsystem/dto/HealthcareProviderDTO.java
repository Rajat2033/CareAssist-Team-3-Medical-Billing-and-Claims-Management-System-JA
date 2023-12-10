package com.hexaware.medicalbillingsystem.dto;
/*
	@Author :  Hema Sree 
	Modified Date : 06-11-2023
	Description :DTO class for HealthcareProvider containing various properties
	*/
	
public class HealthcareProviderDTO {

	private int providerId;
	private String providerName;
	private String providerPassword;
	private String providerEmail;
	private String providerGender;
	private String providerSpeciality;
	private String providerDesignation;
	private int providerExperience;
	private String providerQualification;

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderPassword() {
		return providerPassword;
	}

	public void setProviderPassword(String providerPassword) {
		this.providerPassword = providerPassword;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderGender() {
		return providerGender;
	}

	public void setProviderGender(String providerGender) {
		this.providerGender = providerGender;
	}

	public String getProviderSpeciality() {
		return providerSpeciality;
	}

	public void setProviderSpeciality(String providerSpeciality) {
		this.providerSpeciality = providerSpeciality;
	}

	public String getProviderDesignation() {
		return providerDesignation;
	}

	public void setProviderDesignation(String providerDesignation) {
		this.providerDesignation = providerDesignation;
	}

	public int getProviderExperience() {
		return providerExperience;
	}

	public void setProviderExperience(int providerExperience) {
		this.providerExperience = providerExperience;
	}

	public String getProviderQualification() {
		return providerQualification;
	}

	public void setProviderQualification(String providerQualification) {
		this.providerQualification = providerQualification;
	}

}
