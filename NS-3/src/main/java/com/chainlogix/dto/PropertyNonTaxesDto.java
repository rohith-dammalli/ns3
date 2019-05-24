package com.chainlogix.dto;

public class PropertyNonTaxesDto {
	
	private int propNonTaxId;
	private int processQueueId;
	private String levyCode;
	private String levyAuthority;
	private int taxes;
	private boolean successFlag;

	public boolean isSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
	
	public int getPropNonTaxId() {
		return propNonTaxId;
	}
	public void setPropNonTaxId(int propNonTaxId) {
		this.propNonTaxId = propNonTaxId;
	}
	public int getProcessQueueId() {
		return processQueueId;
	}
	public void setProcessQueueId(int processQueueId) {
		this.processQueueId = processQueueId;
	}
	public String getLevyCode() {
		return levyCode;
	}
	public void setLevyCode(String levyCode) {
		this.levyCode = levyCode;
	}
	public String getLevyAuthority() {
		return levyAuthority;
	}
	public void setLevyAuthority(String levyAuthority) {
		this.levyAuthority = levyAuthority;
	}
	public int getTaxes() {
		return taxes;
	}
	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	
	
	

}
