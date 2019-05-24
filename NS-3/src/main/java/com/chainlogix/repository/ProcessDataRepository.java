package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chainlogix.entity.ProcessDataEntity;

public interface ProcessDataRepository extends JpaRepository<ProcessDataEntity, Integer> {

	
	@Query(value = "SELECT * FROM process_data where  process_queueId=:processQueueId ", nativeQuery = true)
	ProcessDataEntity findByprocessQueueId(Integer processQueueId);

}
