package com.chainlogix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity	
@Table(name="property_taxes")
public class PropertyTaxesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyTaxId;
	
	@OneToOne
	@JoinColumn(name="process_queueId")
	private  ProcessQueueEntity processQueueEntity;
	
	@Column(name="tax_code")
	private String taxCode;
	
	@Column(name="tax_authority")
	private String taxAuthority;
	
	@Column(name="assessed_value")
	private int assessedValue;
	
	@Column(name="exception_amount")
	private int excemptionAmount;
	
	@Column(name="taxable_value")
	private int taxableValue;
	
	@Column(name="milagerates")
	private int milagerates;
	
	@Column(name="taxes")
	private int taxes;
	
	public int getPropertyTaxId() {
		return propertyTaxId;
	}
	public void setPropertyTaxId(int propertyTaxId) {
		this.propertyTaxId = propertyTaxId;
	}
	
	public ProcessQueueEntity getProcessQueueEntity() {
		return processQueueEntity;
	}
	public void setProcessQueueEntity(ProcessQueueEntity processQueueEntity) {
		this.processQueueEntity = processQueueEntity;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getTaxAuthority() {
		return taxAuthority;
	}
	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}
	public int getAssessedValue() {
		return assessedValue;
	}
	public void setAssessedValue(int assessedValue) {
		this.assessedValue = assessedValue;
	}
	public int getExcemptionAmount() {
		return excemptionAmount;
	}
	public void setExcemptionAmount(int excemptionAmount) {
		this.excemptionAmount = excemptionAmount;
	}
	public int getTaxableValue() {
		return taxableValue;
	}
	public void setTaxableValue(int taxableValue) {
		this.taxableValue = taxableValue;
	}
	public int getMilagerates() {
		return milagerates;
	}
	public void setMilagerates(int milagerates) {
		this.milagerates = milagerates;
	}
	public int getTaxes() {
		return taxes;
	}
	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	
	
	
	
}
