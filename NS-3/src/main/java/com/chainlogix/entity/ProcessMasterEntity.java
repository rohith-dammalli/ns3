package com.chainlogix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="process_master")
public class ProcessMasterEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="process_masterId")
	private int processMasterId;
	
	@Column(name="process_steps")
	private String processSteps;
	
	@Column(name="process_desc")
	private String processDesc;

	public int getProcessMasterId() {
		return processMasterId;
	}

	public void setProcessMasterId(int processMasterId) {
		this.processMasterId = processMasterId;
	}

	public String getProcessSteps() {
		return processSteps;
	}

	public void setProcessSteps(String processSteps) {
		this.processSteps = processSteps;
	}

	public String getProcessDesc() {
		return processDesc;
	}

	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
