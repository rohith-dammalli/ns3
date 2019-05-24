package com.chainlogix.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="property_tax_dues")
public class PropertyTaxDuesEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertytaxDueId;
	
	
	@OneToOne
	@JoinColumn(name="process_queueId")
	private  ProcessQueueEntity processQueueEntity;
	
	@Column(name="account")
	private String account;
	
	@Column(name="folio")
	private String folio;
	
	@Column(name="taxes")
	private int taxes;
	
	@Column(name="fees")
	private int fees;
	
	@Column(name="interest")
	private int interest;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="paid")
	private int paid;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="amount")
	private int amount;
	
	public int getPropertytaxDueId() {
		return propertytaxDueId;
	}

	public void setPropertytaxDueId(int propertytaxDueId) {
		this.propertytaxDueId = propertytaxDueId;
	}

	public ProcessQueueEntity getProcessQueueEntity() {
		return processQueueEntity;
	}

	public void setProcessQueueEntity(ProcessQueueEntity processQueueEntity) {
		this.processQueueEntity = processQueueEntity;
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
