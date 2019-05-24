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
@Table(name="process_status")
public class ProcessStatusEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="process_statusId")
	private int processStatusId;
	
	@OneToOne
    @JoinColumn(name="process_queueId")
    private ProcessQueueEntity processQueueEntity;
	
	@OneToOne
    @JoinColumn(name="process_masterId")
    private ProcessMasterEntity processMasterEntity;
	
	@Column(name ="created_timestamp")
	private Timestamp createdBy;
	
	@Column(name = "completed_timestamp")
	private Timestamp completedBy;
	
	@Column(name="process_status")
	private String processStatus;



	public int getProcessStatusId() {
		return processStatusId;
	}

	public void setProcessStatusId(int processStatusId) {
		this.processStatusId = processStatusId;
	}

	public ProcessQueueEntity getProcessQueueEntity() {
		return processQueueEntity;
	}

	public void setProcessQueueEntity(ProcessQueueEntity processQueueEntity) {
		this.processQueueEntity = processQueueEntity;
	}

	public ProcessMasterEntity getProcessMasterEntity() {
		return processMasterEntity;
	}

	public void setProcessMasterEntity(ProcessMasterEntity processMasterEntity) {
		this.processMasterEntity = processMasterEntity;
	}

	public Timestamp getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(Timestamp completedBy) {
		this.completedBy = completedBy;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	
	

}
