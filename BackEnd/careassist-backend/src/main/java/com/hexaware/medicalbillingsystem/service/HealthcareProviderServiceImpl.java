package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystem.repository.HealthcareProviderRepository;
/*
@Author :  Hema Sree  
Modified Date : 02-11-2023
Description :Service Implementation class for HealthcareProvider implementing IHealthcareProviderService
*/
@Service
public class HealthcareProviderServiceImpl implements IHealthcareProviderService {

	Logger logger=LoggerFactory.getLogger(HealthcareProviderServiceImpl.class);
	
	@Autowired
	private HealthcareProviderRepository repository;

	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto) {
		HealthcareProvider provider = new HealthcareProvider();

		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(encoder.encode(providerdto.getProviderPassword()));
//		provider.setProviderPassword(providerdto.getProviderPassword());
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderGender(providerdto.getProviderGender());
		provider.setProviderSpeciality(providerdto.getProviderSpeciality());
		provider.setProviderDesignation(providerdto.getProviderDesignation());
		provider.setProviderExperience(providerdto.getProviderExperience());
		provider.setProviderQualification(providerdto.getProviderQualification());
		logger.info("Provider is successfully added!!!!!");
		return repository.save(provider);
	}

	@Override
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto) {

		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderId(providerdto.getProviderId());
		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(encoder.encode(providerdto.getProviderPassword()));
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderGender(providerdto.getProviderGender());
		provider.setProviderSpeciality(providerdto.getProviderSpeciality());
		provider.setProviderDesignation(providerdto.getProviderDesignation());
		provider.setProviderExperience(providerdto.getProviderExperience());
		provider.setProviderQualification(providerdto.getProviderQualification());
		logger.info("Provider is updated sucessfully!!!!!");
		return repository.save(provider);
	}

	@Override
	public void deleteProvider(int providerId) {
		logger.warn("Provider with id "+providerId+" is deleted!!!");
		repository.deleteById(providerId);

	}

	@Override
	public List<HealthcareProvider> getAllHealthcareProviders() {
		logger.info("All HealthcareProvider Data is fetched!!!!!");
		return repository.findAll();
	}

	@Override
	public HealthcareProviderDTO getProviderById(int providerId) {

		
		HealthcareProvider provider=repository.findById(providerId).orElse(new HealthcareProvider());
		HealthcareProviderDTO providerdto=new HealthcareProviderDTO();
		providerdto.setProviderId(provider.getProviderId());
		providerdto.setProviderName(provider.getProviderName());
		providerdto.setProviderPassword(provider.getProviderPassword());
		providerdto.setProviderEmail(provider.getProviderEmail());
		providerdto.setProviderGender(provider.getProviderGender());
		providerdto.setProviderSpeciality(provider.getProviderSpeciality());
		providerdto.setProviderDesignation(provider.getProviderDesignation());
		providerdto.setProviderExperience(provider.getProviderExperience());
		providerdto.setProviderQualification(provider.getProviderQualification());
		logger.info("Provider with id "+providerId+" is fetched!!");
		return providerdto;
	}

}
