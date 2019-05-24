package com.chainlogix.dto;

import java.sql.Date;

public class ProcessDataDto {

	private int processDataId;
	private int processQueueId;
	private String requestNumber;
	private int assessedValue;
	
	private String mailingAddress;
	private String milageCode;
	private String legalDescription;
	private String taxLegalDescription;
	private int ipbTaxes;
	private int ipbFees;
	private int ipbInterest;
	private int ipbDiscount;
	private Date ifPaidBy;
	private boolean successFlag;
	
	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	private int ipbAmountDue;
	public int getProcessDataId() {
		return processDataId;
	}
	public void setProcessDataId(int processDataId) {
		this.processDataId = processDataId;
	}
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
	}
	public String getReNumber() {
		return requestNumber;
	}
	public void setReNumber(String reNumber) {
		this.requestNumber = reNumber;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getMilageCode() {
		return milageCode;
	}
	public void setMilageCode(String milageCode) {
		this.milageCode = milageCode;
	}
	public String getLegalDescription() {
		return legalDescription;
	}
	public void setLegalDescription(String legalDescription) {
		this.legalDescription = legalDescription;
	}
	public String getTaxLegalDescription() {
		return taxLegalDescription;
	}
	public void setTaxLegalDescription(String taxLegalDescription) {
		this.taxLegalDescription = taxLegalDescription;
	}
	public int getIpbTaxes() {
		return ipbTaxes;
	}
	public void setIpbTaxes(int ipbTaxes) {
		this.ipbTaxes = ipbTaxes;
	}
	public int getIpbFees() {
		return ipbFees;
	}
	public void setIpbFees(int ipbFees) {
		this.ipbFees = ipbFees;
	}
	public int getIpbInterest() {
		return ipbInterest;
	}
	public void setIpbInterest(int ipbInterest) {
		this.ipbInterest = ipbInterest;
	}
	public int getIpbDiscount() {
		return ipbDiscount;
	}
	public void setIpbDiscount(int ipbDiscount) {
		this.ipbDiscount = ipbDiscount;
	}
	public Date getIfPaidBy() {
		return ifPaidBy;
	}
	public void setIfPaidBy(Date ifPaidBy) {
		this.ifPaidBy = ifPaidBy;
	}
	
	public int getIpbAmountDue() {
		return ipbAmountDue;
	}
	public void setIpbAmountDue(int ipbAmountDue) {
		this.ipbAmountDue = ipbAmountDue;
	}
	
	public void setAssessedValue(int assessedValue) {
		this.assessedValue = assessedValue;
	}
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	public int getAssessedValue() {
		return assessedValue;
	}
	
}
