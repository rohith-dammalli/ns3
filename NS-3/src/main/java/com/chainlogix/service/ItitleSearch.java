package com.chainlogix.service;

import java.util.List;

import javax.mail.MessagingException;

import com.chainlogix.dto.AddressDataDto;
import com.chainlogix.dto.ProcessDataDto;
import com.chainlogix.dto.ProcessStatusDto;
import com.chainlogix.dto.PropertyDetailsDto;
import com.chainlogix.dto.PropertyNonTaxesDto;
import com.chainlogix.dto.PropertyTaxDuesDto;
import com.chainlogix.dto.PropertyTaxesDto;
import com.chainlogix.dto.QuestionaireDto;

public interface ItitleSearch {

	
	public List<AddressDataDto> fetchAddressDesc();
	
	public String saveProcesStatus(ProcessStatusDto processStatusDto);

	public void sendMail() throws MessagingException;
	
	public List<QuestionaireDto> fetchQuestionList();
	
	public ProcessDataDto fetchProcessData(int addressId,int clientId);

	public List<PropertyDetailsDto> fetchPropertyDetails(int addressId, int clientId);

	public List<PropertyTaxesDto> fetchPropertyTax(int addressId, int clientId);

	public List<PropertyNonTaxesDto> fetchPropertyNonTax(int addressId, int clientId);

	public List<PropertyTaxDuesDto> fetchPropertyTaxDues(int addressId, int clientId);
	
}
