package com.hexaware.medicalbillingsystem.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.medicalbillingsystem.entities.Patients;
/*
@Author :Hema sree
Modified Date : 16-11-2023
Description :  Class for  PatientInfoPatientDetails containing various properties
*/
public class PatientInfoPatientDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String patientName;
	private String patientPassword;
	private List<GrantedAuthority> authorities;

	public PatientInfoPatientDetails(Patients patients) {
		patientName = patients.getPatientName();
		patientPassword = patients.getPatientPassword();
		authorities = Arrays.stream(patients.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		return patientPassword;
	}

	@Override
	public String getUsername() {
		return patientName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
