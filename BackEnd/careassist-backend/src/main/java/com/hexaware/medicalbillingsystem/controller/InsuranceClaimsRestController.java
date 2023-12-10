package com.hexaware.medicalbillingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystem.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystem.service.IInsuranceClaimsService;

/*
@Author :  Rajat Darvhekar 
Modified Date : 14-11-2023
Description : Controller  InsuranceClaims
*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/insuranceclaims")
public class InsuranceClaimsRestController {

	@Autowired
	private IInsuranceClaimsService claimService;

	@PostMapping("/add/newclaim/{patientName}/{planId}")

	@PreAuthorize("hasAuthority('PATIENTS')")
	public InsuranceClaims insertNewClaim(@RequestBody InsuranceClaimsDTO claimDTO,@PathVariable String patientName,@PathVariable int planId) {
		System.out.println(patientName);
		return claimService.insertClaims(claimDTO,patientName,planId);
	}

	@PutMapping("/update/claim/{claimId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceClaims updateStatus(@RequestBody InsuranceClaimsDTO claimDTO, @PathVariable long claimId) {
		return claimService.updateClaimStatus(claimDTO, claimId);
	}

	@GetMapping("/getclaimbyid/{claimId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceClaimsDTO getClaimById(@PathVariable long claimId) {
		return claimService.getById(claimId);
	}

	@GetMapping("/getallclaims/{claimStatus}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceClaims> getAllClaimsSorted(@PathVariable String claimStatus) {
		return claimService.getSortedInsuranceClaims(claimStatus);

	}
	
	@GetMapping("/getclaim/{patientName}")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public List<InsuranceClaims> getClaimMadeByPatient(@PathVariable String patientName)
	{
		return claimService.getClaimByPatientName(patientName);
		
	}
	
	@GetMapping("/getclaims/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public List<InsuranceClaims> getClaimByCompanyName(@PathVariable String companyName)
	{
		return claimService.getClaimsByPlanNameAndCompanyName(companyName);
	}
	
}
