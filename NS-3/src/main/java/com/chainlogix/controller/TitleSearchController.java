package com.chainlogix.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainlogix.dto.AddressDataDto;
import com.chainlogix.dto.ClientInfoDto;
import com.chainlogix.dto.ProcessDataDto;
import com.chainlogix.dto.ProcessStatusDto;
import com.chainlogix.dto.PropertyDetailsDto;
import com.chainlogix.dto.PropertyNonTaxesDto;
import com.chainlogix.dto.PropertyTaxDuesDto;
import com.chainlogix.dto.PropertyTaxesDto;
import com.chainlogix.dto.QuestionaireDto;
import com.chainlogix.entity.ClientCheckListEntity;
import com.chainlogix.entity.ClientDataEntity;
import com.chainlogix.entity.ProcessQueueEntity;
import com.chainlogix.repository.ClientChecklistRepository;
import com.chainlogix.repository.ClientDataRepository;
import com.chainlogix.repository.ProcessQueueRepository;
import com.chainlogix.service.ItitleSearch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class TitleSearchController {

	@Autowired
	ItitleSearch ititleSearch;
	
	@Autowired
	ClientDataRepository clientDataRepository;
	
	@Autowired
	ClientChecklistRepository clientChecklistRepository;
	
	@Autowired
	ProcessQueueRepository processQueueRepository;
	
	ProcessQueueEntity pqueue = new ProcessQueueEntity();
	
	@GetMapping(value ="/fetchAddress")
	public ResponseEntity<String> fetchAddr() 
	{
		List<AddressDataDto> result = ititleSearch.fetchAddressDesc();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
	}
	
	
	@PostMapping(value="/saveClientInfo")
	public ResponseEntity<String> saveClientInfo(@RequestBody ClientInfoDto clientInfoDto) throws MessagingException
	{
		ClientDataEntity clienInfoEntity = new ClientDataEntity();
		clienInfoEntity.setContactNumber(clientInfoDto.getClientcontactNum());
		clientInfoDto.setClientMailId(clientInfoDto.getClientMailId());
		clienInfoEntity.setName(clientInfoDto.getClientName());
		clienInfoEntity = clientDataRepository.saveAndFlush(clienInfoEntity);
		ProcessQueueEntity processQueueEntity =	processQueueRepository.findFirstByOrderByProcessQueueIdDesc();
		processQueueEntity.setClientDataEntity(clienInfoEntity);
		processQueueRepository.saveAndFlush(processQueueEntity);
		 ititleSearch.sendMail(); 
		if(!StringUtils.isEmpty(clienInfoEntity))
			return new ResponseEntity<>("Client Data Saved successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("Failure in saving the Data",HttpStatus.OK);
	}
	
	
	@PostMapping(value="/saveInfoToTrigger")
	public ResponseEntity<String> saveInfoToTrigger(@RequestBody ProcessStatusDto processStatusDto) 
	{
		String result = ititleSearch.saveProcesStatus(processStatusDto);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
 
	@GetMapping(value ="/sendMail")
	public ResponseEntity<String> sendMail() throws MessagingException 
	{
		ititleSearch.sendMail();
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@PostMapping(value="/createQuestionaire")
	public ResponseEntity<String> createQuestion(@RequestBody QuestionaireDto questionaireDto)
	{
		ClientCheckListEntity centity = new ClientCheckListEntity();
		centity.setQuestions(questionaireDto.getClientQuestion());
		centity.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		ClientCheckListEntity response =	clientChecklistRepository.saveAndFlush(centity);
		if(!StringUtils.isEmpty(response))
			return new ResponseEntity<>("Success",HttpStatus.OK);
		else
			return new ResponseEntity<>("Error",HttpStatus.OK);

	}
	
	
	
	@GetMapping(value="/fetchQuestionaire")
	public ResponseEntity<String> fetchQuestions()
	{
		List<QuestionaireDto> result = ititleSearch.fetchQuestionList();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/fetchProcessdata")
	public ResponseEntity<String> fetchProcessdata(@RequestParam int addressId,@RequestParam int clientId)
	{
		ProcessDataDto processDataDto = ititleSearch.fetchProcessData(addressId, clientId);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(processDataDto), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/fetchPropertyDetails")
	public ResponseEntity<String> fetchPropertyDetails(@RequestParam int addressId,@RequestParam int clientId)
	{
		List<PropertyDetailsDto> processDataDto = ititleSearch.fetchPropertyDetails(addressId, clientId);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(processDataDto), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/fetchPropertyTax")
	public ResponseEntity<String> fetchPropertyTax(@RequestParam int addressId,@RequestParam int clientId)
	{
		List<PropertyTaxesDto> propertyTaxesDto = ititleSearch.fetchPropertyTax(addressId, clientId);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(propertyTaxesDto), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/fetchPropertyNonTax")
	public ResponseEntity<String> fetchPropertyNonTax(@RequestParam int addressId,@RequestParam int clientId)
	{
		List<PropertyNonTaxesDto> propertyNonTaxesDto = ititleSearch.fetchPropertyNonTax(addressId, clientId);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(propertyNonTaxesDto), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/fetchPropertyTaxDues")
	public ResponseEntity<String> fetchPropertyTaxDues(@RequestParam int addressId,@RequestParam int clientId)
	{
		List<PropertyTaxDuesDto> propertyTaxDuesDto = ititleSearch.fetchPropertyTaxDues(addressId, clientId);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(propertyTaxDuesDto), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/fetchClientId")
	public ResponseEntity<String> getClientIdFromName(@RequestParam String clientName) {
		ClientDataEntity clientDataEntity = clientDataRepository.findFirstByNameOrderByClientpkDesc(clientName);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return new ResponseEntity<>(gson.toJson(clientDataEntity), HttpStatus.OK);
		
	}
	
	
}
