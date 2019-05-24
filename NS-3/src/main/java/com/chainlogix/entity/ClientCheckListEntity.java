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
@Table(name="client_checklist")
public class ClientCheckListEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="checklist_id")
	private int checkListId;
	
	@OneToOne
	@JoinColumn(name="client_pk")
	private ClientDataEntity clientDataEntity;

	@Column(name="question")
	private String questions;
	
	@Column(name="client_feedback")
	private String clientFeedback;
	
	@Column(name="client_comments")
	private String comments;
	
	@Column(name="created_on")
	private Timestamp createdOn;

	public int getCheckListId() {
		return checkListId;
	}

	public void setCheckListId(int checkListId) {
		this.checkListId = checkListId;
	}

	public ClientDataEntity getClientDataEntity() {
		return clientDataEntity;
	}

	public void setClientDataEntity(ClientDataEntity clientDataEntity) {
		this.clientDataEntity = clientDataEntity;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getClientFeedback() {
		return clientFeedback;
	}

	public void setClientFeedback(String clientFeedback) {
		this.clientFeedback = clientFeedback;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
}
