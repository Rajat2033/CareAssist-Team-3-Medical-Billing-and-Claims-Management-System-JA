package com.hexaware.medicalbillingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.AdminMedicalDTO;
import com.hexaware.medicalbillingsystem.entities.AdminMedical;
import com.hexaware.medicalbillingsystem.repository.AdminMedicalRepository;

/*
@Author:Hema sree
Date:18-11-2023
Description:Service class for AdminMedical implenting IAdminMedicalService
*/

@Service
public class AdminMedicalServiceImpl implements IAdminMedicalService {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AdminMedicalRepository repository;

	@Override
	public AdminMedical insertNewAdmin(AdminMedicalDTO adminDTO) {
		AdminMedical admin = new AdminMedical();
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminPassword(encoder.encode(adminDTO.getAdminPassword()));
		return repository.save(admin);
	}

	@Override
	public AdminMedical updateAdmin(AdminMedicalDTO adminDTO, int adminId) {
		Optional<AdminMedical> adminOpt = repository.findById(adminId);
		AdminMedical admin = new AdminMedical();
		if(adminOpt.isPresent())
		{
		admin=adminOpt.get();
		admin.setAdminPassword(encoder.encode(adminDTO.getAdminPassword()));
		}
		return repository.save(admin);
	}

}
