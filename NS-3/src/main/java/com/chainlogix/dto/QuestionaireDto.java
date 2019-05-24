package com.chainlogix.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class QuestionaireDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int checkListId;
	public int getCheckListId() {
		return checkListId;
	}
	public void setCheckListId(int checkListId) {
		this.checkListId = checkListId;
	}
	private int clientId;
	private String clientQuestion;
	private String clientFeedback;
	private String clientComments;
	private Timestamp createdOn;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientQuestion() {
		return clientQuestion;
	}
	public void setClientQuestion(String clientQuestion) {
		this.clientQuestion = clientQuestion;
	}
	public String getClientFeedback() {
		return clientFeedback;
	}
	public void setClientFeedback(String clientFeedback) {
		this.clientFeedback = clientFeedback;
	}
	public String getClientComments() {
		return clientComments;
	}
	public void setClientComments(String clientComments) {
		this.clientComments = clientComments;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
