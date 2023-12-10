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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystem.dto.AdminMedicalDTO;
import com.hexaware.medicalbillingsystem.dto.AuthRequest;
import com.hexaware.medicalbillingsystem.entities.AdminMedical;
import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystem.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystem.entities.InsurancePlans;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.service.AuthJWTService;
import com.hexaware.medicalbillingsystem.service.IAdminMedicalService;
import com.hexaware.medicalbillingsystem.service.IHealthcareProviderService;
import com.hexaware.medicalbillingsystem.service.IInsuranceClaimsService;
import com.hexaware.medicalbillingsystem.service.IInsurancePlansService;
import com.hexaware.medicalbillingsystem.service.IPatientsService;

/*
@Author :  Hema Sree  
Modified Date : 14-11-2023
Description : Controller  for Admin 
*/

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminMedicalRestController {

	@Autowired
	private IHealthcareProviderService providerService;

	@Autowired
	private IPatientsService patientService;

	@Autowired
	private IInsuranceClaimsService claimService;

	@Autowired
	private IInsurancePlansService planService;
	Logger logger = LoggerFactory.getLogger(AdminMedicalRestController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthJWTService jwtService;

	@Autowired
	private IAdminMedicalService adminService;

	@PostMapping("/add")
	public AdminMedical insertNewAdmin(@RequestBody AdminMedicalDTO adminDTO) {
		return adminService.insertNewAdmin(adminDTO);

	}
	

	@PutMapping("/update/admin/{adminId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public AdminMedical updateAdmin(@RequestBody AdminMedicalDTO adminDTO, @PathVariable int adminId) {
		return adminService.updateAdmin(adminDTO, adminId);
	}

	@GetMapping("/getallpatients")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Patients> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/getallproviders")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<HealthcareProvider> getAllHealthcareProviders() {
		return providerService.getAllHealthcareProviders();
	}

	@GetMapping("/getallinsuranceclaims")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceClaims> getAllInsuranceClaims() {
		return claimService.getAllInsuranceClaims();
	}

	@GetMapping("/getallinsuranceplans")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsurancePlans> getAllInsurancePlans() {
		return planService.getAllPlans();
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
