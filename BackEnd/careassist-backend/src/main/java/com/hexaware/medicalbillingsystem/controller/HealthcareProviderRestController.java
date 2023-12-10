package com.hexaware.medicalbillingsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystem.dto.AuthRequest;
import com.hexaware.medicalbillingsystem.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystem.service.AuthJWTService;
import com.hexaware.medicalbillingsystem.service.IHealthcareProviderService;

/*
@Author :   Rajat Darvhekar  
Modified Date : 14-11-2023
Description : Controller  for HealthcareProvider
*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/provider")
public class HealthcareProviderRestController {

	Logger logger = LoggerFactory.getLogger(HealthcareProviderRestController.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private AuthJWTService jwtService;
	@Autowired
	private IHealthcareProviderService service;

	@PostMapping(path = "/add/provider", consumes = "application/json", produces = "application/json")
	public HealthcareProvider insertNewProvider(@RequestBody HealthcareProviderDTO providerdto) {
		return service.addProvider(providerdto);
	}

	@PutMapping("/update/provider")
	@PreAuthorize("hasAuthority('PROVIDER')")
	public HealthcareProvider updateprovider(@RequestBody HealthcareProviderDTO providerdto) {
		return service.updateProvider(providerdto);
	}

	@GetMapping("/getall/provider")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<HealthcareProvider> getAllProviders() {
		return service.getAllHealthcareProviders();
	}

	@DeleteMapping("/delete/provider/{providerId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteProvider(@PathVariable int providerId) {
		service.deleteProvider(providerId);
		return "Provider with id " + providerId + " is deleted";
	}

	@GetMapping("/getById/{providerId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public HealthcareProviderDTO getProviderById(int providerId) {
		return service.getProviderById(providerId);
	}

	@PostMapping("/authenticate")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {

		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));

		// If authentication is successful, generate a JWT
		String Token = null;
		if (authenticate.isAuthenticated()) {
			Token = jwtService.generateToken(authReq.getUsername());
			logger.info("JWT Token successfully generated!!!");
		}

		else {
			logger.info("Not Found USERNAME!!!!");
			throw new UsernameNotFoundException("UserName Not Found!!!! ");
		}
		return Token;

	}
}
