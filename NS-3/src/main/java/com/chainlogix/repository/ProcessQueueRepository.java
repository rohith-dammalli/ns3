package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.ProcessQueueEntity;

@Repository
public interface ProcessQueueRepository extends JpaRepository<ProcessQueueEntity, Integer>{

	@Query(value = "SELECT process_queueId FROM process_queue where address_id=:addressId and client_id=:clientId", nativeQuery = true)
	public int findProcessQueueIdByAddressIdAndClientpk(@Param("addressId")int addressId,@Param("clientId")int clientId);

	
	public ProcessQueueEntity findFirstByOrderByProcessQueueIdDesc();

}
