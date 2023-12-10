package com.hexaware.medicalbillingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystem.entities.InsurancePlans;
/*
@Author :   Rajat Darvhekar  
Modified Date :06-11-2023
Description : Repository for InsurancePlans class extending JpaRepository
*/
@Repository
public interface InsurancePlansRepository extends JpaRepository<InsurancePlans, Integer> {

	@Query("select plans from InsurancePlans plans where plans.company.companyName=?1")
	List<InsurancePlans> findByCompanyName(String companyName);
	List<InsurancePlans> findByPlanType(String planType);
}
