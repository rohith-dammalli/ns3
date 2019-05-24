package com.chainlogix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chainlogix.entity.PropertyDetailsEntity;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetailsEntity, Integer>{

	
	@Query(value = "SELECT * FROM process_property_details where  process_queueId=:processQueueId ", nativeQuery = true)
	public List<PropertyDetailsEntity> findByprocessQueueId(int processQueueId);
	
}
