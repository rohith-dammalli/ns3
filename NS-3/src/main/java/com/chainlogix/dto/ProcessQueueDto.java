package com.chainlogix.dto;

import java.sql.Date;

public class ProcessQueueDto {

	private int processQueueId;
	private AddressDataDto addressDataDto;
	private ClientInfoDto clientInfoDto;
	private Date createdBy;
	private Date completedBy;
	private String status;
	
	
	
	
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
	}
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCompletedBy() {
		return completedBy;
	}
	public void setCompletedBy(Date completedBy) {
		this.completedBy = completedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AddressDataDto getAddressDataDto() {
		return addressDataDto;
	}
	public void setAddressDataDto(AddressDataDto addressDataDto) {
		this.addressDataDto = addressDataDto;
	}
	public ClientInfoDto getClientInfoDto() {
		return clientInfoDto;
	}
	public void setClientInfoDto(ClientInfoDto clientInfoDto) {
		this.clientInfoDto = clientInfoDto;
	} 
	
	
	
}
