package com.hexaware.medicalbillingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.hexaware.medicalbillingsystem.dto.PatientsDTO;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.repository.PatientRepository;
/*
@Author : Hema Sree 
Modified Date : 18-11-2023
Description : ServiceImpTest class for the Patients
*/
class PatientsServiceImplTest {
	@Mock
	PatientRepository patientRepositoryMock;

	@Autowired
	PatientRepository patientRepository;

	@Mock
	private PasswordEncoder passwordEncoderMock;

	@MockBean
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	PatientsServiceImpl patientService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddPatients() {

		PatientsDTO patientsDTO = new PatientsDTO();
		Patients patients = new Patients();
		patients.setPatientId(patientsDTO.getPatientId());
		patients.setPatientName(patientsDTO.getPatientName());
		patients.setPatientAddress(patientsDTO.getPatientAddress());
		patients.setPatientContact(patientsDTO.getPatientContact());
		patients.setPatientDOB(patientsDTO.getPatientDOB());
		patients.setPatientDisease(patientsDTO.getPatientDisease());
		patients.setPatientEmail(patientsDTO.getPatientEmail());
		patients.setPatientGender(patientsDTO.getPatientGender());
		patients.setPatientPassword(patientsDTO.getPatientPassword());
		when(passwordEncoderMock.encode(patientsDTO.getPatientPassword())).thenReturn("encodedPassword");
		when(patientRepositoryMock.save(any(Patients.class))).thenReturn(patients);
		Patients createdPatients = patientService.addPatients(patientsDTO);
		verify(passwordEncoderMock).encode(patientsDTO.getPatientPassword());
		verify(patientRepositoryMock).save(any(Patients.class));
		
		assertEquals(patients.getPatientId(),createdPatients.getPatientId());
		assertEquals(patients.getPatientName(), createdPatients.getPatientName());
		assertEquals(patients.getPatientPassword(), createdPatients.getPatientPassword());
		assertEquals(patients.getPatientAddress(), createdPatients.getPatientAddress());
		assertEquals(patients.getPatientContact(), createdPatients.getPatientContact());
		assertEquals(patients.getPatientDisease(), createdPatients.getPatientDisease());
		assertEquals(patients.getPatientDOB(), createdPatients.getPatientDOB());
		assertEquals(patients.getPatientEmail(), createdPatients.getPatientEmail());
		assertEquals(patients.getPatientGender(), createdPatients.getPatientGender());
		assertEquals(patients.getRole(), createdPatients.getRole());

		
	}

	@Test
	void testUpdatepatients() {
		PatientsDTO patientsDTO = new PatientsDTO();
		Patients patients = new Patients();
		patientsDTO.setPatientId(patients.getPatientId());
		patientService.updatepatients(patientsDTO);
	}

	@Test
	void testDeletePatients() {
		PatientsDTO patientsDTO = new PatientsDTO();
		long patientId;
		patientId = patientsDTO.getPatientId();

		patientService.deletePatients(patientId);
		verify(patientRepositoryMock, times(1)).deleteById(patientId);
	}

	@Test
	void testGetPatientByName() {

		Patients existingPatient = new Patients();
		existingPatient.setPatientId(existingPatient.getPatientId());
		existingPatient.setPatientName(existingPatient.getPatientName());
		when(patientRepositoryMock.findByPatientName(existingPatient.getPatientName()))
				.thenReturn(Optional.of(existingPatient));
		PatientsDTO patientDTO = patientService.getPatientByName(existingPatient.getPatientName());
		verify(patientRepositoryMock).findByPatientName(existingPatient.getPatientName());
		assertEquals(existingPatient.getPatientName(), patientDTO.getPatientName());

	}

	@Test
	void testGetAllPatients() {
		patientService.getAllPatients();
		verify(patientRepositoryMock).findAll();
	}

}
