package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import com.hexaware.medicalbillingsystem.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
/*
@Author :  Hema Sree  
Modified Date : 04-11-2023
Description : Interface of  IInsuranceCompanyService performing the following operations
*/
public interface IInsuranceCompanyService {
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto);

	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto,int companyId);

	public void deleteCompanyById(int companyId);

	public InsuranceCompanyDTO getCompanyByName(String companyName);

	public List<InsuranceCompany> getAllInsuranceCompanyDetails();
}
