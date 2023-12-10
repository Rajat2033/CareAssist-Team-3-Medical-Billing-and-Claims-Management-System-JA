package com.hexaware.medicalbillingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystem.entities.InvoiceDetails;
/*
@Author :   Rajat Darvhekar  
Modified Date :06-11-2023
Description : Repository for InvoiceDetails class extending JpaRepository
*/
@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {
	
	@Query("select i from InvoiceDetails i where i.patient.patientName=?1")
	List<InvoiceDetails> getByPatientName(String patientName);

}
