package com.chainlogix.dto;

import java.sql.Date;

public class PropertyDetailsDto {

	
	private int propertyId;
	private int processQueueId;
	private String bookPage;
	private Date salesDate;
	private String deedInstrument;
	private boolean successFlag;
	
	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
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
	
}
