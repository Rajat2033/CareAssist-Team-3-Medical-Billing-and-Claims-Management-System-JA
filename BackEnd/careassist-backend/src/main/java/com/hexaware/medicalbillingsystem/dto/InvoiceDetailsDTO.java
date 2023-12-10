package com.hexaware.medicalbillingsystem.dto;

import java.time.LocalDate;

/*
@Author :  Rajat Darvhekar 
Modified Date : 06-11-2023
Description :DTO class for InvoiceDetails containing various properties
*/
public class InvoiceDetailsDTO {
	private int invoiceId;
	private LocalDate invoiceDate;
	private LocalDate invoiceDueDate;
	private double invoiceTax;
	private double consultationFee;
	private double diagnosticTestsFee;
	private double diagnosticScanFee;
	private double invoiceTotalAmount;
	private double totalBillAmount;

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {

		this.totalBillAmount = invoiceTotalAmount + (invoiceTotalAmount * (invoiceTax / 100));
	}

	public void setInvoiceTotalAmount(double invoiceTotalAmount) {
		this.invoiceTotalAmount = consultationFee + diagnosticScanFee + diagnosticTestsFee;
	}

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

	public double getInvoiceTax() {
		return invoiceTax;
	}

	public void setInvoiceTax(double invoiceTax) {
		this.invoiceTax = invoiceTax;
	}

	public double getInvoiceTotalAmount() {
		return invoiceTotalAmount;
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
}
