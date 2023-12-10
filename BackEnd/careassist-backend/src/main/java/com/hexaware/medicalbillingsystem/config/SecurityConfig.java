package com.hexaware.medicalbillingsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.medicalbillingsystem.filter.JWTAuthFilter;

import static org.springframework.security.config.Customizer.withDefaults;


/*
@Author : Rajat Darvhekar 
Modified Date : 16-11-2023
Description :  Class for SecurityConfig  containing various properties
*/

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired()
	JWTAuthFilter authFilter;

	@Bean
	// authentication
	public UserDetailsService userDetailsService() {

		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**",
                        "/api/v1/patients/authenticate", "/api/v1/patients/add/new", "/api/v1/patients/get/allPatients",
                        "/api/v1/provider/authenticate", "/api/v1/provider/add/provider",
                        "/api/v1/companies/authenticate", "/api/v1/companies/add/company",
                        "/api/v1/admin/authenticate", "/api/v1/admin/add", "/api/v1/adminmedical/getallpatients", "/api/v1/adminmedical/getallinsuranceplans",
                        "/api/v1/provider/delete/provider/{providerId}",
                        "/api/v1/insuranceclaims/add/newclaim", "/api/v1/insuranceclaims/getallclaims/{claimStatus}"
                )
                .permitAll().and().authorizeHttpRequests()
                .requestMatchers("/api/v1/admin/**","/api/v1/patients/**", "/api/v1/provider/**", "/api/v1/companies/**",
                        "/api/v1/insuranceplans/**", "/api/v1/insuranceclaims/**", "/api/v1/invoicedetails/**")
                .authenticated().and() // .formLogin().and().build();
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager getAuthenticateManager(AuthenticationConfiguration configure) throws Exception {
		return configure.getAuthenticationManager();
	}

}
