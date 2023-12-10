package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import com.hexaware.medicalbillingsystem.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceClaims;
/*
@Author :  Hema Sree 
Modified Date : 04-11-2023
Description : Interface of  IInsuranceClaimsService performing the following operations
*/
public interface IInsuranceClaimsService {
	
	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO,String patientName,int planId);

	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO,long claimId);

	public List<InsuranceClaims> getClaimByPatientName(String patientName);
 
	public InsuranceClaimsDTO getById(long claimId);
	 
	public List<InsuranceClaims> getSortedInsuranceClaims(String claimStatus);
	
	public List<InsuranceClaims> getAllInsuranceClaims();
	
	public List<InsuranceClaims>  getClaimsByPlanNameAndCompanyName(String companyName);

	

}
