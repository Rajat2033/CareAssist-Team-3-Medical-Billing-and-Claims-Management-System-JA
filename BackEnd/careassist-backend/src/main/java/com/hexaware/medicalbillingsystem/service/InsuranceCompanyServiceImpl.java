package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystem.exceptions.CompanyNotRegisteredException;
import com.hexaware.medicalbillingsystem.repository.InsuranceCompanyRepository;
/*
@Author :  Hema Sree 
Modified Date : 04-11-2023
Description :Service Implementation class for InsuranceCompanyServiceImpl implementing IInsuranceCompanyService
*/
@Service
public class InsuranceCompanyServiceImpl implements IInsuranceCompanyService {

	Logger logger=LoggerFactory.getLogger(InsuranceCompanyServiceImpl.class);
	@Autowired
	private InsuranceCompanyRepository repository;

	@Autowired
	PasswordEncoder encoder;
	@Override
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto) {

		InsuranceCompany company = new InsuranceCompany();
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyPassword(encoder.encode(companydto.getCompanyPassword()));
//		company.setCompanyPassword(companydto.getCompanyPassword());
		company.setCompanyEmail(companydto.getCompanyEmail());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyStartYears(companydto.getCompanyStartYears());
		logger.info("New Insurance Company is registered with us!!!");
		return repository.save(company);
	}

	@Override
	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto,int companyId) {

		InsuranceCompany insuranceCompany=repository.findById(companyId).orElse(new InsuranceCompany());
		InsuranceCompany company = new InsuranceCompany();
		company.setCompanyId(companydto.getCompanyId());
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyPassword(encoder.encode(companydto.getCompanyPassword()));
		company.setCompanyEmail(companydto.getCompanyEmail());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyStartYears(companydto.getCompanyStartYears());
		logger.info("Existing Insurance Company is Updated !!!!");
		return repository.save(company);
	}

	@Override
	public void deleteCompanyById(int companyId) {
		logger.warn("Insurance Company with id "+companyId+" is deleted!!!!");
		repository.deleteById(companyId);

	}

	@Override
	public InsuranceCompanyDTO getCompanyByName(String companyName) {

		InsuranceCompany company = repository.findByCompanyName(companyName)
				.orElseThrow(() -> new CompanyNotRegisteredException(HttpStatus.SERVICE_UNAVAILABLE,
						"Company With name : " + companyName + " has not registered with us !!"));
		InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
		companyDTO.setCompanyId(company.getCompanyId());
		companyDTO.setCompanyName(company.getCompanyName());
		companyDTO.setCompanyPassword(company.getCompanyPassword());
		companyDTO.setCompanyEmail(company.getCompanyEmail());
		companyDTO.setCompanyContact(company.getCompanyContact());
		companyDTO.setCompanyStartYears(company.getCompanyStartYears());
		logger.info("Company with name "+companyName+" is displayed!!!!");
		return companyDTO;
	}

	@Override
	public List<InsuranceCompany> getAllInsuranceCompanyDetails() {

		logger.info("All the insurance Companies Data is fetched!!!!!");
		return repository.findAll();
	}

}
