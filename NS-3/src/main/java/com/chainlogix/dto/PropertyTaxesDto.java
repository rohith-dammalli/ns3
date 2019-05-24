package com.chainlogix.dto;

public class PropertyTaxesDto {

	
	private int propertyTaxId;
	private int processQueueId;
	private String taxCode;
	private String taxAuthority;
	private int assessedValue;
	private int excemptionAmount;
	private int taxableValue;
	private int milagerates;
	private int taxes;
	private boolean successFlag;
	
	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	public int getPropertyTaxId() {
		return propertyTaxId;
	}
	public void setPropertyTaxId(int propertyTaxId) {
		this.propertyTaxId = propertyTaxId;
	}
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
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
