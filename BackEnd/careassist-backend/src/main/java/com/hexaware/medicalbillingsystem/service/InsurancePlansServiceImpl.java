package com.hexaware.medicalbillingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystem.entities.InsurancePlans;
import com.hexaware.medicalbillingsystem.repository.InsuranceCompanyRepository;
import com.hexaware.medicalbillingsystem.repository.InsurancePlansRepository;

/*
@Author :   Rajat Darvhekar  
Modified Date : 02-11-2023
Description :Service Implementation class for InsurancePlansServiceImpl implementing IInsurancePlansService
*/
@Service
public class InsurancePlansServiceImpl implements IInsurancePlansService {

	Logger logger = LoggerFactory.getLogger(InsurancePlansServiceImpl.class);
	@Autowired
	private InsurancePlansRepository repository;
	
	@Autowired
	private InsuranceCompanyRepository companyRepository;

	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto,String companyName) {

		InsuranceCompany company= companyRepository.findByCompanyName(companyName).orElse(new InsuranceCompany());
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanType(plansdto.getPlanType());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanEmi(plansdto.getPlanEmi());
		plans.setPlanDetails(plansdto.getPlanDetails());
		plans.setCompany(company);
		logger.info("New insurance plan is added!!!");
		return repository.save(plans);
	}

	@Override
	public void deleteInsurancePlan(int planId) {
		logger.warn("Insurance plans " + planId + " is deleted!!!");
		repository.deleteById(planId);

	}

	@Override
	public List<InsurancePlansDTO> getPlanByType(String planType) {
		List<InsurancePlans> plans = repository.findByPlanType(planType);
		List<InsurancePlansDTO> list=new ArrayList<>();
		for (InsurancePlans plan : plans) {
			InsurancePlansDTO planDTO = new InsurancePlansDTO();
			planDTO.setPlanId(plan.getPlanId());
			planDTO.setPlanName(plan.getPlanName());
			planDTO.setPlanType(plan.getPlanType());
			planDTO.setPlanCoverAmount(plan.getPlanCoverAmount());
			planDTO.setPlanEmi(plan.getPlanEmi());
			planDTO.setPlanDetails(plan.getPlanDetails());
			list.add(planDTO);
			logger.info("Insurance plan " + planType + " is displayed!!!");
		}
		
		return list;

	}

	@Override
	public List<InsurancePlans> getAllPlans() {
		logger.info("All the InsurancePlans are displayed!!!!");
		return repository.findAll();
	}

	@Override
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto) {
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanId(plansdto.getPlanId());
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanType(plansdto.getPlanType());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanEmi(plansdto.getPlanEmi());
		plans.setPlanDetails(plansdto.getPlanDetails());
		logger.warn("Insurance plan is updated!!!");
		return repository.save(plans);
	}

	@Override
	public List<InsurancePlans> getPlansByCompanyName(String companyName) {
		
		return repository.findByCompanyName(companyName);
	}

}
