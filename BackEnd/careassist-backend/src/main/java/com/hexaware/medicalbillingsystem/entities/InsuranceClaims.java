package com.hexaware.medicalbillingsystem.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
/*
@Author : Rajat Darvhekar  
Modified Date : 28-10-2023
Description : Entity class for InsuranceClaims containing various properties
*/
@Entity
public class InsuranceClaims implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="claimSeq",initialValue = 10,allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "claimSeq")
	private long claimId;

	@DecimalMin(value = "40000.00")
	@DecimalMax(value = "100000.00")
	private double claimAmount;
	private String claimStatus;

	@DecimalMin(value = "12000.00")
	@DecimalMax(value = "100000.00")
	private double invoiceAmount;
	
	@OneToOne
	@JoinColumn(name = "patientId")
	private Patients patient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planId")
	private InsurancePlans plans;

	public InsuranceClaims() {
		super();

	}

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

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public InsurancePlans getPlans() {
		return plans;
	}

	public void setPlans(InsurancePlans plans) {
		this.plans = plans;
	}

	public InsuranceClaims(long claimId, double claimAmount, String claimStatus,
			@DecimalMin("12000.00") @DecimalMax("100000.00") double invoiceAmount, Patients patient,
			InsurancePlans plans) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.invoiceAmount = invoiceAmount;
		this.patient = patient;
		this.plans = plans;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

}
