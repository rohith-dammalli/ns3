package com.chainlogix.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="process_queue")
public class ProcessQueueEntity implements Serializable {
	
	
	public Timestamp getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(Timestamp completedBy) {
		this.completedBy = completedBy;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="process_queueId")
	private int processQueueId;
	
	@OneToOne
    @JoinColumn(name="address_id")
    private AddressEntity addressEntity;
	
	@OneToOne
	@JoinColumn(name="client_id")
	private ClientDataEntity clientDataEntity;
	
	
	@Column(name ="created_timestamp")
	private Timestamp createdBy;
	
	@Column(name = "completed_timestamp")
	private Timestamp completedBy;
	
	@Column(name="process_status")
	private String processStatus;

	public int getProcessQueueId() {
		return processQueueId;
	}

	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public ClientDataEntity getClientDataEntity() {
		return clientDataEntity;
	}

	public void setClientDataEntity(ClientDataEntity clientDataEntity) {
		this.clientDataEntity = clientDataEntity;
	}

	public Timestamp getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	
	

}
