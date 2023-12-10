package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystem.entities.InvoiceDetails;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.exceptions.NoSuchInvoiceGeneratedException;
import com.hexaware.medicalbillingsystem.repository.InvoiceDetailsRepository;
import com.hexaware.medicalbillingsystem.repository.PatientRepository;

/*
@Author :   Rajat Darvhekar
Modified Date : 04-11-2023
Description :Service Implementation class for InvoiceDetailsServiceImpl implementing InvoiceDetailsService
*/
@Service
public class InvoiceDetailsServiceImpl implements IInvoiceDetailsService {

	Logger logger = LoggerFactory.getLogger(InvoiceDetailsServiceImpl.class);

	@Autowired
	private InvoiceDetailsRepository invoiceRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public InvoiceDetails generateInvoice(InvoiceDetailsDTO detailsDTO,long patientId) {
		InvoiceDetails details = new InvoiceDetails();
		Patients patients=patientRepository.findById(patientId).orElse(new Patients());
		details.setInvoiceDate(detailsDTO.getInvoiceDate());
		details.setInvoiceDueDate(detailsDTO.getInvoiceDueDate());
		details.setInvoiceTax(detailsDTO.getInvoiceTax());
		details.setConsultationFee(detailsDTO.getConsultationFee());
		details.setDiagnosticTestsFee(detailsDTO.getDiagnosticTestsFee());
		details.setDiagnosticScanFee(detailsDTO.getDiagnosticScanFee());
		details.setInvoiceTotalAmount(detailsDTO.getInvoiceTotalAmount());
		details.setTotalBillAmount(detailsDTO.getTotalBillAmount());
		details.setPatient(patients);
		logger.info("Invoice Generated Successfully for patient "+patientId+" !!!!!!!");
		return invoiceRepository.save(details);
	}

	@Override
	public List<InvoiceDetails> getAllGeneratedInvoice() {
		logger.info("All the Invoice Generated Details Fetched Successfully!!!!!");
		return invoiceRepository.findAll();
	}

	@Override
	public InvoiceDetails getInvoiceById(int invoiceId) {
		InvoiceDetails details = invoiceRepository.findById(invoiceId)
				.orElseThrow(() -> new NoSuchInvoiceGeneratedException(HttpStatus.NO_CONTENT,
						"No such Invoice with Id :" + invoiceId + " Found"));
		InvoiceDetailsDTO detailsDTO = new InvoiceDetailsDTO();
		detailsDTO.setInvoiceId(details.getInvoiceId());
		detailsDTO.setInvoiceDate(details.getInvoiceDate());
		detailsDTO.setInvoiceDueDate(details.getInvoiceDueDate());
		detailsDTO.setInvoiceTax(details.getInvoiceTax());
		detailsDTO.setConsultationFee(details.getConsultationFee());
		detailsDTO.setDiagnosticTestsFee(details.getDiagnosticTestsFee());
		detailsDTO.setDiagnosticScanFee(details.getDiagnosticScanFee());
		logger.info("Fetched the Invoice by Id " + invoiceId + " !!!!!!!!!");
		return details;
	}

	

	@Override
	public List<InvoiceDetails> getAllByPatientName(String patientName) {
		
		return invoiceRepository.getByPatientName(patientName);
	}

}
