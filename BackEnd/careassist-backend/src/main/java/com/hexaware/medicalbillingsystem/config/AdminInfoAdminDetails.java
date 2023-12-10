package com.hexaware.medicalbillingsystem.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.medicalbillingsystem.entities.AdminMedical;
/*
@Author:Rajat Darvehkar
Date:18-11-2023
Description:AdminInfoAdminDetails class implementing UserDetails
*/	
public class AdminInfoAdminDetails implements UserDetails{

	
	private String adminName;
	private String adminPassword;
	private List<GrantedAuthority> authorities;
	
	
	public AdminInfoAdminDetails(AdminMedical adminMedical) {
		adminName=adminMedical.getAdminName();
		adminPassword=adminMedical.getAdminPassword();
		authorities=Arrays.stream(adminMedical.getRole().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return adminPassword;
	}

	@Override
	public String getUsername() {
		return adminName;
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
