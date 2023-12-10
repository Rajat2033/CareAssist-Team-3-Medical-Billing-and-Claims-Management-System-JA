package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.PatientsDTO;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.repository.PatientRepository;
/*
@Author :   Rajat Darvhekar  
Modified Date : 04-11-2023
Description :Service Implementation class for PatientsServiceImpl implementing PatientsService
*/
@Service
public class PatientsServiceImpl implements IPatientsService {

	Logger logger = LoggerFactory.getLogger(PatientsServiceImpl.class);
	@Autowired
	private PatientRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Patients addPatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patient.setPatientPassword(passwordEncoder.encode(patientsdto.getPatientPassword()));
//		patient.setPatientPassword(patientsdto.getPatientPassword());
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		logger.info("New patient/user registered with us!!!");
		return repository.save(patient);
	}

	@Override
	public Patients updatepatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		patient.setPatientId(patientsdto.getPatientId());
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patient.setPatientPassword(passwordEncoder.encode(patientsdto.getPatientPassword()));
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		logger.warn("Patient with id:"+patient.getPatientId()+" is updated!!!!");
		return repository.save(patient);
	}

	@Override
	public void deletePatients(long patientId) {
		logger.warn("Patient with id " + patientId + " is deleted!!!!");
		repository.deleteById(patientId);

	}

	@Override
	public PatientsDTO getPatientByName(String patientName) {
		Patients patient = repository.findByPatientName(patientName).orElse(new Patients());
		PatientsDTO patientdto = new PatientsDTO();
		patientdto.setPatientId(patient.getPatientId());
		patientdto.setPatientName(patient.getPatientName());
		patientdto.setPatientEmail(patient.getPatientEmail());
		patientdto.setPatientDOB(patient.getPatientDOB());
		patientdto.setPatientGender(patient.getPatientGender());
		patientdto.setPatientContact(patient.getPatientContact());
		patientdto.setPatientAddress(patient.getPatientAddress());
		patientdto.setPatientDisease(patient.getPatientDisease());
		logger.info("Patient with name:"+patientName+" is fetched!!!");
		return patientdto;
	}

	@Override
	public List<Patients> getAllPatients() {
		logger.info("All the Patients Data is received!!!");
		return repository.findAll();
	}


}
