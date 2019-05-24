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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	
}
