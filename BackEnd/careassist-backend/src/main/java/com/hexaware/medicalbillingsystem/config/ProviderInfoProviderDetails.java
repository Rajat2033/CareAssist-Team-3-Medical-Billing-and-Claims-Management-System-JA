package com.hexaware.medicalbillingsystem.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
 /*
@Author : Rajat Darvhekar 
Modified Date : 16-11-2023
Description :  Class for  ProviderInfoProviderDetails containing various properties
*/
public class ProviderInfoProviderDetails implements UserDetails {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String providerName;
	private String providerPassword;
	private List<GrantedAuthority> authorities;
	
	public ProviderInfoProviderDetails(HealthcareProvider provider)
	{
		providerName=provider.getProviderName();
		providerPassword=provider.getProviderPassword();
		authorities=Arrays.stream(provider.getRole().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
			return providerPassword;
	}

	@Override
	public String getUsername() {
	
		return providerName;
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
