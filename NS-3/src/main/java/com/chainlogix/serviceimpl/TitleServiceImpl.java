package com.chainlogix.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.chainlogix.dto.AddressDataDto;
import com.chainlogix.dto.ProcessDataDto;
import com.chainlogix.dto.ProcessStatusDto;
import com.chainlogix.dto.PropertyDetailsDto;
import com.chainlogix.dto.PropertyNonTaxesDto;
import com.chainlogix.dto.PropertyTaxDuesDto;
import com.chainlogix.dto.PropertyTaxesDto;
import com.chainlogix.dto.QuestionaireDto;
import com.chainlogix.entity.AddressEntity;
import com.chainlogix.entity.ClientCheckListEntity;
import com.chainlogix.entity.ClientDataEntity;
import com.chainlogix.entity.ProcessDataEntity;
import com.chainlogix.entity.ProcessMasterEntity;
import com.chainlogix.entity.ProcessQueueEntity;
import com.chainlogix.entity.ProcessStatusEntity;
import com.chainlogix.entity.PropertyDetailsEntity;
import com.chainlogix.entity.PropertyNonTaxesEntity;
import com.chainlogix.entity.PropertyTaxDuesEntity;
import com.chainlogix.entity.PropertyTaxesEntity;
import com.chainlogix.repository.AddressRepository;
import com.chainlogix.repository.ClientChecklistRepository;
import com.chainlogix.repository.ClientDataRepository;
import com.chainlogix.repository.ProcessDataRepository;
import com.chainlogix.repository.ProcessMasterRepository;
import com.chainlogix.repository.ProcessQueueRepository;
import com.chainlogix.repository.ProcessStatusRepository;
import com.chainlogix.repository.PropertyDetailsRepository;
import com.chainlogix.repository.PropertyNonTaxesRepository;
import com.chainlogix.repository.PropertyTaxDuesRepository;
import com.chainlogix.repository.PropertyTaxesRepository;
import com.chainlogix.service.ItitleSearch;

@Service
public class TitleServiceImpl implements ItitleSearch {
	
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ProcessStatusRepository processStatusRepository;
	
	@Autowired
	ProcessMasterRepository processMasterRepository;
	
	@Autowired
	ProcessQueueRepository processQueueRepository;
	
	@Autowired
	ClientDataRepository clientDataRepository;
	
	@Autowired
	PropertyTaxDuesRepository propertyTaxDuesRepository;
	
	@Autowired
	PropertyNonTaxesRepository propertyNonTaxesRepository;
	
	@Autowired
	ClientChecklistRepository clientChecklistRepository;
	
	@Autowired
	PropertyTaxesRepository propertyTaxesRepository;
	
	ProcessStatusEntity pstatus = new ProcessStatusEntity();
	
	ProcessQueueEntity pqueue = new ProcessQueueEntity();
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;
	
	@Autowired
	private ProcessDataRepository processDataRepository;
	
	@Override
	public List<AddressDataDto> fetchAddressDesc() {
		
		List<AddressEntity> addr = addressRepository.findAll();
		List<AddressDataDto> addrres = new ArrayList<>();
		if(!StringUtils.isEmpty(addr))
				{
					for (AddressEntity addressEntity : addr) {
						AddressDataDto adddesc = new AddressDataDto();
						adddesc.setAddressDesc(addressEntity.getAddressDesc());
						adddesc.setAddressId(addressEntity.getAddressID());
						addrres.add(adddesc);
					}
				}
		return addrres;
	}

	@Override
	public String saveProcesStatus(ProcessStatusDto processStatusDto) {
		ClientDataEntity clienInfoEntity = new ClientDataEntity();
		clienInfoEntity.setName("hello");
		clienInfoEntity = clientDataRepository.saveAndFlush(clienInfoEntity);
		
		Optional<AddressEntity> adr=addressRepository.findById(processStatusDto.getAddressId());
		pqueue.setAddressEntity(adr.get());
		pqueue.setClientDataEntity(null);
		pqueue.setCreatedBy(new Timestamp(System.currentTimeMillis()));
		pqueue.setCompletedBy(new Timestamp(System.currentTimeMillis()));
		pqueue.setProcessStatus(processStatusDto.getStatus());
		ProcessQueueEntity res =processQueueRepository.saveAndFlush(pqueue);
		
		List<ProcessMasterEntity> pme = processMasterRepository.findAll();
		List<ProcessStatusEntity> pse = new ArrayList<>();
		Optional<ProcessQueueEntity> pqr=processQueueRepository.findById(res.getProcessQueueId());
		for (ProcessMasterEntity processMasterEntity : pme) {
			ProcessStatusEntity ps = new ProcessStatusEntity();
			ps.setProcessQueueEntity(pqr.get());
			ps.setProcessMasterEntity(processMasterEntity);
			ps.setCreatedBy(new Timestamp(System.currentTimeMillis()));
			ps.setCompletedBy(new Timestamp(System.currentTimeMillis()));
			ps.setProcessStatus(processStatusDto.getStatus());
			pse.add(ps);
		}
		
		processStatusRepository.saveAll(pse);
		
		if(!StringUtils.isEmpty(res))
		{
		return "Success";
		}
		else
		{
		return "failure";
		}
		}

	@Override
	public void sendMail() throws MessagingException {
		/*
		 * SimpleMailMessage msg = new SimpleMailMessage();
		 * msg.setTo("rohith@chain-logix.com");
		 * 
		 * msg.setSubject("Testing from Spring Boot");
		 * msg.setText("Hello World \n Spring Boot Email");
		 * 
		 * javaMailSender.send(msg);
		 */
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String htmlMsg = "<h3>Hello World!</h3>";
		mimeMessage.setContent(htmlMsg, "text/html");
		helper.setTo("rohith@chain-logix.com");
		helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
		helper.setFrom("abc@gmail.com");
		
		javaMailSender.send(mimeMessage);
		
	}

	@Override
	public List<QuestionaireDto> fetchQuestionList() {
		List<QuestionaireDto> qto = new ArrayList<>();
		List<ClientCheckListEntity>  checkEntity = clientChecklistRepository.findAll();
		for (ClientCheckListEntity clientCheckListEntity : checkEntity) {
			QuestionaireDto qt = new QuestionaireDto();
			qt.setClientQuestion(clientCheckListEntity.getQuestions());
			qt.setCheckListId(clientCheckListEntity.getCheckListId());
			qto.add(qt);
		}
		return qto;
	}

	@Override
	public ProcessDataDto fetchProcessData(int addressId, int clientId) {
		ProcessDataDto processDataDto = new ProcessDataDto();
		ProcessDataEntity processDataEntity =null;
		Integer processQueueId = processQueueRepository.findProcessQueueIdByAddressIdAndClientpk(addressId, clientId);
		if(!StringUtils.isEmpty(processQueueId))
		{
			processDataEntity = processDataRepository.findByprocessQueueId(processQueueId);
			if(!StringUtils.isEmpty(processDataEntity)) {
			BeanUtils.copyProperties(processDataEntity, processDataDto); 
			}
		}
		if(!StringUtils.isEmpty(processDataDto)) {
			processDataDto.setSuccessFlag(true);
			return processDataDto;
		}
		else {
			processDataDto.setSuccessFlag(false);
			return processDataDto;
		}
	}

	@Override
	public List<PropertyDetailsDto> fetchPropertyDetails(int addressId, int clientId) {
		
		List<PropertyDetailsDto> propertyDetailsDto = new ArrayList<>();
		List<PropertyDetailsEntity> propertyDetailsEntity =null;
		Integer processQueueId = processQueueRepository.findProcessQueueIdByAddressIdAndClientpk(addressId, clientId);
		if(!StringUtils.isEmpty(processQueueId))
		{
			propertyDetailsEntity = propertyDetailsRepository.findByprocessQueueId(processQueueId);
			if(!StringUtils.isEmpty(propertyDetailsEntity)) {
				for (PropertyDetailsEntity propertyDetailsEntity2 : propertyDetailsEntity) {
					PropertyDetailsDto pdd = new PropertyDetailsDto();
					BeanUtils.copyProperties(propertyDetailsEntity2, pdd); 
					propertyDetailsDto.add(pdd);
				}
			
			}
		}
		return propertyDetailsDto;
		/*
		 * if(!StringUtils.isEmpty(propertyDetailsDto)) {
		 * propertyDetailsDto.setSuccessFlag(true); return propertyDetailsDto; } else {
		 * propertyDetailsDto.setSuccessFlag(false); return propertyDetailsDto; }
		 */
	}

	@Override
	public List<PropertyTaxesDto> fetchPropertyTax(int addressId, int clientId) {
		List<PropertyTaxesDto> propertyTaxesList = new ArrayList<>();
		List<PropertyTaxesEntity> propertyTaxesEntity =null;
		Integer processQueueId = processQueueRepository.findProcessQueueIdByAddressIdAndClientpk(addressId, clientId);
		if(!StringUtils.isEmpty(processQueueId))
		{
			propertyTaxesEntity = propertyTaxesRepository.findByprocessQueueId(processQueueId);
			if(!StringUtils.isEmpty(propertyTaxesEntity)) {
				for (PropertyTaxesEntity propertyTaxesEntity2 : propertyTaxesEntity) {
					PropertyTaxesDto propertyTaxesDto = new PropertyTaxesDto();
					BeanUtils.copyProperties(propertyTaxesEntity2, propertyTaxesDto); 
					propertyTaxesList.add(propertyTaxesDto);
					
				}
			
			}
		}
		return propertyTaxesList;
		/*
		 * if(!StringUtils.isEmpty(propertyTaxesDto)) {
		 * propertyTaxesDto.setSuccessFlag(true); return propertyTaxesDto; } else {
		 * propertyTaxesDto.setSuccessFlag(false); return propertyTaxesDto; }
		 */
	}

	@Override
	public List<PropertyNonTaxesDto> fetchPropertyNonTax(int addressId, int clientId) {
		List<PropertyNonTaxesDto> propertyNonTaxesList = new ArrayList<>();
		List<PropertyNonTaxesEntity> propertyNonTaxesEntity =null;
		Integer processQueueId = processQueueRepository.findProcessQueueIdByAddressIdAndClientpk(addressId, clientId);
		if(!StringUtils.isEmpty(propertyNonTaxesList))
		{
			propertyNonTaxesEntity = propertyNonTaxesRepository.findByprocessQueueId(processQueueId);
			if(!StringUtils.isEmpty(propertyNonTaxesEntity)) {
				for (PropertyNonTaxesEntity propertyNonTaxesEntity2 : propertyNonTaxesEntity) {
					PropertyNonTaxesDto propertyNonTaxesDto = new PropertyNonTaxesDto();
					BeanUtils.copyProperties(propertyNonTaxesEntity2, propertyNonTaxesDto);
					propertyNonTaxesList.add(propertyNonTaxesDto);
				}
			 
			}
		}
		
		return propertyNonTaxesList;
		/*
		 * if(!StringUtils.isEmpty(propertyNonTaxesDto)) {
		 * propertyNonTaxesDto.setSuccessFlag(true); return propertyNonTaxesDto; } else
		 * { propertyNonTaxesDto.setSuccessFlag(false); return propertyNonTaxesDto; }
		 */
	}

	@Override
	public List<PropertyTaxDuesDto> fetchPropertyTaxDues(int addressId, int clientId) {
		List<PropertyTaxDuesDto> propertyTaxDuesList = new ArrayList<>();
		List<PropertyTaxDuesEntity> propertyTaxDuesEntity =null;
		Integer processQueueId = processQueueRepository.findProcessQueueIdByAddressIdAndClientpk(addressId, clientId);
		if(!StringUtils.isEmpty(processQueueId))
		{
			propertyTaxDuesEntity = propertyTaxDuesRepository.findByprocessQueueId(processQueueId);
			if(!StringUtils.isEmpty(propertyTaxDuesEntity)) {
				for (PropertyTaxDuesEntity propertyTaxDuesEntity2 : propertyTaxDuesEntity) {
					PropertyTaxDuesDto propertyTaxDuesDto = new PropertyTaxDuesDto();
					BeanUtils.copyProperties(propertyTaxDuesEntity2, propertyTaxDuesDto); 
					propertyTaxDuesList.add(propertyTaxDuesDto);
				}
			
			}
		}
		/*
		 * if(!StringUtils.isEmpty(propertyTaxDuesDto)) {
		 * propertyTaxDuesDto.setSuccessFlag(true); return propertyTaxDuesDto; } else {
		 * propertyTaxDuesDto.setSuccessFlag(false); return propertyTaxDuesDto; }
		 */
	return propertyTaxDuesList;
	
	}
	
	

}
