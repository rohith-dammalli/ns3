package com.chainlogix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client_info")
public class ClientDataEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="client_pk")
	private int clientpk;
	
	@Column(name="client_name")
	private String name;
	
	@Column(name="client_mailId")
	private String mailId;
	
	@Column(name="client_contact")
	private String contactNumber;
	
	
	
	
	public int getClientpk() {
		return clientpk;
	}
	public void setClientpk(int clientpk) {
		this.clientpk = clientpk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
