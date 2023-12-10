package com.hexaware.medicalbillingsystem.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
/*
@Author :Hema sree
Modified Date : 16-11-2023
Description :  Class for CompanyInfoCompanyDetails containing various properties
*/
public class CompanyInfoCompanyDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companyName;
	private String companyPassword;
	private List<GrantedAuthority> authorities;
	
	public CompanyInfoCompanyDetails(InsuranceCompany company)
	{
		companyName=company.getCompanyName();
		companyPassword=company.getCompanyPassword();
		authorities=Arrays.stream(company.getRole().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		return companyPassword;
	}

	@Override
	public String getUsername() {
		return companyName;
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
