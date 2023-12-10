package com.hexaware.medicalbillingsystem.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.medicalbillingsystem.entities.AdminMedical;
import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.repository.AdminMedicalRepository;
import com.hexaware.medicalbillingsystem.repository.HealthcareProviderRepository;
import com.hexaware.medicalbillingsystem.repository.InsuranceCompanyRepository;
import com.hexaware.medicalbillingsystem.repository.PatientRepository;

@Component

 /*
@Author : Rajat Darvhekar 
Modified Date : 16-11-2023
Description :  Class for   UserInfoUserDetailsService implementing UserDetailsService
*/

public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HealthcareProviderRepository providerRepository;
	
	@Autowired
	private InsuranceCompanyRepository companyRepository;
	
	@Autowired
	private AdminMedicalRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Patients> patient=patientRepository.findByPatientName(username);
		Optional<HealthcareProvider> provider=providerRepository.findByProviderName(username);
		Optional<InsuranceCompany> company=companyRepository.findByCompanyName(username);
		Optional<AdminMedical> adminInfo=adminRepository.findByAdminName(username);
		
		if(patient.isPresent())
		{
			
	        return patient.map(PatientInfoPatientDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Patient not found " + username));

		}
		if(provider.isPresent())
		{
	        return provider.map(ProviderInfoProviderDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Provider not found " + username));
			
		}
		if(company.isPresent())
		{

	        return company.map(CompanyInfoCompanyDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Company not found " + username));
		}
		if(adminInfo.isPresent())
		{

	        return adminInfo.map(AdminInfoAdminDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Admin not found " + username));
		}
		throw new UsernameNotFoundException("UserName Not Found :"+username);
	}

}
