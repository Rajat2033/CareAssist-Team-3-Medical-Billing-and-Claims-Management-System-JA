package com.hexaware.medicalbillingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystem.entities.AdminMedical;
/*
@Author:Hema sree
Date:15-11-2023
Description: Repository class for AdminMadical performing the following properties
*/	
@Repository
public interface AdminMedicalRepository extends JpaRepository<AdminMedical, Integer> {
	
	Optional<AdminMedical> findByAdminName(String adminName);

}
