package com.chainlogix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="property_non_taxes")
public class PropertyNonTaxesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyNonTaxId;
	
	@OneToOne
	@JoinColumn(name="process_queueId")
	private  ProcessQueueEntity processQueueEntity;
	
	@Column(name="levy_code")
	private String levyCode;
	
	@Column(name="levy_authority")
	private String levyAuthority;
	
	@Column(name="taxes")
	private int taxes;

	public int getPropertyNonTaxId() {
		return propertyNonTaxId;
	}

	public void setPropertyNonTaxId(int propertyNonTaxId) {
		this.propertyNonTaxId = propertyNonTaxId;
	}

	public ProcessQueueEntity getProcessQueueEntity() {
		return processQueueEntity;
	}

	public void setProcessQueueEntity(ProcessQueueEntity processQueueEntity) {
		this.processQueueEntity = processQueueEntity;
	}

	public String getLevyCode() {
		return levyCode;
	}

	public void setLevyCode(String levyCode) {
		this.levyCode = levyCode;
	}

	public String getLevyAuthority() {
		return levyAuthority;
	}

	public void setLevyAuthority(String levyAuthority) {
		this.levyAuthority = levyAuthority;
	}

	public int getTaxes() {
		return taxes;
	}

	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	
	
	
}
