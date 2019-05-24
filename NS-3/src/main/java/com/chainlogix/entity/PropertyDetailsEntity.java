package com.chainlogix.entity;

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
@Table(name="process_property_details")
public class PropertyDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="property_detailsId")
	private int propertyDetailId;
	
	@OneToOne
	@JoinColumn(name="process_queueId")
	private  ProcessQueueEntity processQueueEntity;
	
	@Column(name="book_page")
	private String bookPage;
	
	@Column(name="sales_date")
	private Date salesDate;
	
	@Column(name="deed_instrument")
	private String deedInstrument;

	public int getPropertyDetailId() {
		return propertyDetailId;
	}

	public void setPropertyDetailId(int propertyDetailId) {
		this.propertyDetailId = propertyDetailId;
	}



	public String getBookPage() {
		return bookPage;
	}

	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public String getDeedInstrument() {
		return deedInstrument;
	}

	public void setDeedInstrument(String deedInstrument) {
		this.deedInstrument = deedInstrument;
	}

	public ProcessQueueEntity getProcessQueueEntity() {
		return processQueueEntity;
	}

	public void setProcessQueueEntity(ProcessQueueEntity processQueueEntity) {
		this.processQueueEntity = processQueueEntity;
	}
}
