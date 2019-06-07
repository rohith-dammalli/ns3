package com.chainlogix.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="process_data")
public class ProcessDataEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="processDataId")
	private int processDataId;
	
	@Column(name="process_queueId")
	private int processQueueId;
	
	@Column(name="request_number")
	private String requestNumber;
	
	@Column(name="assessed_value")
	private int assessedValue;
	
	@Column(name="mailing_address")
	private String mailingAddress;
	
	@Column(name="milage_code")
	private String milageCode;
	
	@Column(name="legal_description")
	private String legalDescription;
	
	@Column(name="taxlegal_description")
	private String taxLegalDescription;
	
	@Column(name="ipb_taxes")
	private int ipbTaxes;
	
	@Column(name="ipb_fees")
	private int ipbFees;
	
	@Column(name="ipb_interest")
	private int ipbInterest;
	
	@Column(name="ipb_discount")
	private int ipbDiscount;
	
	@Column(name="if_paidby")
	private Date ifPaidBy;
	
	@Column(name="ipb_amountdue")
	private int ipbAmountDue;

	public int getProcessQueueId() {
		return processQueueId;
	}

	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
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

	public void setAssessedValue(int assessedValue) {
		this.assessedValue = assessedValue;
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

	

	public int getProcessDataId() {
		return processDataId;
	}

	public void setProcessDataId(int processDataId) {
		this.processDataId = processDataId;
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
	
	
}
