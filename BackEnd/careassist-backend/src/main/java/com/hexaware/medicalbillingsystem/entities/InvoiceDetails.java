package com.hexaware.medicalbillingsystem.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

/*
@Author :  Hema Sree  
Modified Date : 28-10-2023
Description : Entity class for InvoiceDetails containing various properties
*/
@Entity
public class InvoiceDetails {

	@Id
	@SequenceGenerator(name = "invoiceSeq", initialValue = 500, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceSeq")
	private int invoiceId;
	private LocalDate invoiceDate;
	private LocalDate invoiceDueDate;

	@NotNull
	private double invoiceTax;
	@DecimalMin(value = "1000.00")
	@DecimalMax(value = "8000.00")
	private double consultationFee;
	private double diagnosticTestsFee;
	private double diagnosticScanFee;

	private double invoiceTotalAmount;

	private double totalBillAmount;
	@OneToOne
	@JoinColumn(name = "patient_Id")
	private Patients patient;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public LocalDate getInvoiceDueDate() {
		return invoiceDueDate;
	}

	public void setInvoiceDueDate(LocalDate invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public double getInvoiceTax() {
		return invoiceTax;
	}

	public void setInvoiceTax(double d) {
		this.invoiceTax = d;
	}

	public double getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}

	public void setInvoiceTotalAmount(double invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;

	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public double getDiagnosticTestsFee() {
		return diagnosticTestsFee;
	}

	public void setDiagnosticTestsFee(double diagnosticTestsFee) {
		this.diagnosticTestsFee = diagnosticTestsFee;
	}

	public double getDiagnosticScanFee() {
		return diagnosticScanFee;
	}

	public void setDiagnosticScanFee(double diagnosticScanFee) {
		this.diagnosticScanFee = diagnosticScanFee;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public InvoiceDetails(int invoiceId, LocalDate invoiceDate, LocalDate invoiceDueDate, @NotNull double invoiceTax,
			@DecimalMin("1000.00") @DecimalMax("8000.00") double consultationFee, double diagnosticTestsFee,
			double diagnosticScanFee, double invoiceTotalAmount, double totalBillAmount, Patients patient) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.invoiceDueDate = invoiceDueDate;
		this.invoiceTax = invoiceTax;
		this.consultationFee = consultationFee;
		this.diagnosticTestsFee = diagnosticTestsFee;
		this.diagnosticScanFee = diagnosticScanFee;
		this.invoiceTotalAmount = invoiceTotalAmount;
		this.totalBillAmount = totalBillAmount;
//		this.patient = patient;
	}

	public InvoiceDetails() {
		super();
	}
}
