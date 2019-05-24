package com.chainlogix.dto;

import java.sql.Timestamp;

public class ProcessStatusDto {
	
	private int addressId;
	private int clientdata;
	public int getClientdata() {
		return clientdata;
	}
	public void setClientdata(int clientdata) {
		this.clientdata = clientdata;
	}
	private Timestamp createdby;
	private Timestamp completedOn;
	private String status;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public Timestamp getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Timestamp createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCompletedOn() {
		return completedOn;
	}
	public void setCompletedOn(Timestamp completedOn) {
		this.completedOn = completedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
