package com.chainlogix.dto;

public class ClientInfoDto {

	
	private int clientInformation;
	public int getClientInformation() {
		return clientInformation;
	}
	public void setClientInformation(int clientInformation) {
		this.clientInformation = clientInformation;
	}
	private String clientName;
	private String clientcontactNum;
	private String clientMailId;
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientcontactNum() {
		return clientcontactNum;
	}
	public void setClientcontactNum(String clientcontactNum) {
		this.clientcontactNum = clientcontactNum;
	}
	public String getClientMailId() {
		return clientMailId;
	}
	public void setClientMailId(String clientMailId) {
		this.clientMailId = clientMailId;
	}
	
	
}
