package com.hexaware.medicalbillingsystem.service;

import com.hexaware.medicalbillingsystem.dto.AdminMedicalDTO;
import com.hexaware.medicalbillingsystem.entities.AdminMedical;
/*
@Author:Rajat Darvehkar
Date:18-11-2023
Description: Interface of IAdminMedicalService
*/	
public interface IAdminMedicalService {
	public AdminMedical insertNewAdmin(AdminMedicalDTO adminDTO);
	public AdminMedical updateAdmin(AdminMedicalDTO adminDTO,int adminId);
	

}
