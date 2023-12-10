package com.hexaware.medicalbillingsystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystem.entities.InsurancePlans;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.exceptions.ClaimNotValidException;
import com.hexaware.medicalbillingsystem.repository.InsuranceClaimsRepository;
import com.hexaware.medicalbillingsystem.repository.InsurancePlansRepository;
import com.hexaware.medicalbillingsystem.repository.PatientRepository;

/*
@Author :  Hema Sree  
Modified Date : 04-11-2023
Description :Service Implementation class for InsuranceClaimsServiceImp implementing IInsuranceClaimsService
*/
@Service
public class InsuranceClaimsServiceImpl implements IInsuranceClaimsService {

	Logger logger = LoggerFactory.getLogger(InsuranceClaimsServiceImpl.class);
	@Autowired
	private InsuranceClaimsRepository repository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private InsurancePlansRepository planRepository;

	@Override
	public InsuranceClaimsDTO getById(long claimId) {
		InsuranceClaims claim = repository.findById(claimId).orElse(new InsuranceClaims());
		InsuranceClaimsDTO claimdto = new InsuranceClaimsDTO();
		claimdto.setClaimId(claim.getClaimId());
		claimdto.setClaimAmount(claim.getClaimAmount());
		claimdto.setClaimStatus(claim.getClaimStatus());
		claimdto.setInvoiceAmount(claim.getInvoiceAmount());
		logger.info("Fetched Claims for id " + claimId);
		return claimdto;
	}

	@Override
	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO, String patientName, int planId) {

		Patients patients = patientRepository.findByPatientName(patientName).orElse(new Patients());
		System.out.println(patients);
		InsurancePlans plans = planRepository.findById(planId).orElse(new InsurancePlans());
		InsuranceClaims claims = new InsuranceClaims();
		claims.setClaimAmount(claimDTO.getClaimAmount());
		claims.setClaimStatus("Pending");
		claims.setInvoiceAmount(claimDTO.getInvoiceAmount());
		claims.setPatient(patients);
		claims.setPlans(plans);
		logger.info("Claim is proceeded!!!");
		return repository.save(claims);
	}

	@Override
	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO, long claimId) {
		Optional<InsuranceClaims> optionalClaims = repository.findById(claimId);
		InsuranceClaims claims = new InsuranceClaims();
		if (optionalClaims.isPresent()) {
			claims = optionalClaims.get();
			
			claims.setClaimStatus(claimsDTO.getClaimStatus());
		} else {
			logger.error("Claim Id Not Found!!!!");
			throw new ClaimNotValidException(HttpStatus.BAD_REQUEST,
					"Claim with Id " + claimId + " os invalid or never processed");
		}
		return repository.save(claims);
	}

	@Override
	public List<InsuranceClaims> getAllInsuranceClaims() {

		logger.info("Fetched All the data!!!!");
		return repository.findAll();
	}

	@Override
	public List<InsuranceClaims> getSortedInsuranceClaims(String claimStatus) {
		logger.info(" claims with status " + claimStatus + "are  fetched!!!");
		return repository.getSortedInsuranceclaims(claimStatus);
	}

	@Override
	public List<InsuranceClaims> getClaimByPatientName(String patientName) {
		return repository.getClaimByPatientName(patientName);
	}

	@Override
	public List<InsuranceClaims> getClaimsByPlanNameAndCompanyName(String companyName) {
		return repository.getAllClaimByPlanNameandByCompanyName(companyName);
	}

}
