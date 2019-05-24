package com.chainlogix.dto;

import java.sql.Date;

public class PropertyTaxDuesDto {
	
	private int propertyDueTaxId;
	private int processQueueId;
	private String account;
	private String folio;
	
	private int taxes;
	private int fees;
	private int interest;
	private int discount;
	private int paid;
	private Date dueDate;
	private int amount;
	private boolean successFlag;

	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	
	public int getPropertyDueTaxId() {
		return propertyDueTaxId;
	}
	public void setPropertyDueTaxId(int propertyDueTaxId) {
		this.propertyDueTaxId = propertyDueTaxId;
	}
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public int getTaxes() {
		return taxes;
	}
	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	

}
