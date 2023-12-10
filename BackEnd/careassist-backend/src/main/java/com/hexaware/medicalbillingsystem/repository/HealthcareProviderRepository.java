package com.hexaware.medicalbillingsystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hexaware.medicalbillingsystem.entities.HealthcareProvider;
/*
@Author : Hema Sree 
Modified Date :08-11-2023
Description : Repository for HealthcareProvider class extending JpaRepository
*/
@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Integer> {

	Optional<HealthcareProvider> findByProviderName(String companyName);
}
