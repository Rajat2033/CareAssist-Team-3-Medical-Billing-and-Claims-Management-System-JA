package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import com.hexaware.medicalbillingsystem.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
/*
@Author :  Hema Sree  
Modified Date : 02-11-2023
Description : Interface of  IHealthcareProviderService performing the following operations
*/
public interface IHealthcareProviderService {

	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto);
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto);
	public void deleteProvider(int providerId);
	
	public List<HealthcareProvider> getAllHealthcareProviders();
	public HealthcareProviderDTO getProviderById(int providerId);

	
}
