package com.hexaware.medicalbillingsystem.dto;


/*
@Author :   Rajat Darvhekar  
Modified Date : 06-11-2023
Description :DTO class for InsurancePlans containing various properties
*/
public class InsurancePlansDTO {
	private int planId;
	private String planName;
	private String planType;
	private double planCoverAmount;
	private double planEmi;
	private String planDetails;
	
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public double getPlanCoverAmount() {
		return planCoverAmount;
	}

	public void setPlanCoverAmount(double planCoverAmount) {
		this.planCoverAmount = planCoverAmount;
	}

	public double getPlanEmi() {
		return planEmi;
	}

	public void setPlanEmi(double planEmi) {
		this.planEmi = planEmi;
	}

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	
}
