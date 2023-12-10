package com.hexaware.medicalbillingsystem.dto;



/*
@Author :  Hema Sree 
Modified Date : 06-11-2023
Description :DTO class for InsuranceClaims containing various properties
*/
public class InsuranceClaimsDTO {
	private long claimId;
	private double claimAmount;
	private String claimStatus;
	private double invoiceAmount;

	
	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	
	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

}
