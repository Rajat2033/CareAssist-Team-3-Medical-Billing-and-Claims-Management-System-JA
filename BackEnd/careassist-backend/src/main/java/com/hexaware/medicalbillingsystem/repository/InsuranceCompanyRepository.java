package com.hexaware.medicalbillingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.medicalbillingsystem.entities.InsuranceCompany;
/*
@Author : Hema Sree   
Modified Date :08-11-2023
Description : Repository for InsuranceCompany class extending JpaRepository
*/

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {

	
	Optional<InsuranceCompany> findByCompanyName(String companyName);
}
