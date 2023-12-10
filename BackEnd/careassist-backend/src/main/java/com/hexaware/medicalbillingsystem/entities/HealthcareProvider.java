package com.hexaware.medicalbillingsystem.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*
@Author : Rajat Darvhekar
Modified Date : 26-10-2023
Description : Entity class for HealthcareProvider containing various properties
*/

@Entity
public class HealthcareProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "providerSeq", initialValue = 100, allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "providerSeq")
	private int providerId;

	@NotBlank
	private String providerName;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Letter must be 8")//Rajat@ss
	private String providerPassword;

	@Email
	private String providerEmail;
	private String providerGender;

	@NotBlank
	private String providerSpeciality;
	private String providerDesignation;

	@NotNull
	private int providerExperience;
	private String providerQualification;

	private final String role="PROVIDER";
	public HealthcareProvider() {
		super();
	}

	public HealthcareProvider(int providerId, @NotBlank String providerName,
			@Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "Letter must be 6") String providerPassword,
			@Email String providerEmail, String providerGender, @NotBlank String providerSpeciality,
			String providerDesignation, @NotNull int providerExperience, String providerQualification) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerPassword = providerPassword;
		this.providerEmail = providerEmail;
		this.providerGender = providerGender;
		this.providerSpeciality = providerSpeciality;
		this.providerDesignation = providerDesignation;
		this.providerExperience = providerExperience;
		this.providerQualification = providerQualification;
	}

	public String getRole() {
		return role;
	}

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

	@Override
	public String toString() {
		return "HealthcareProvider [providerId=" + providerId + ", providerName=" + providerName + ", providerPassword="
				+ providerPassword + ", providerEmail=" + providerEmail + ", providerGender=" + providerGender
				+ ", providerSpeciality=" + providerSpeciality + ", providerDesignation=" + providerDesignation
				+ ", providerExperience=" + providerExperience + ", providerQualification=" + providerQualification
				+ "]";
	}

}
