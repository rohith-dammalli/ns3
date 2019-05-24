package com.chainlogix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chainlogix.entity.PropertyTaxDuesEntity;

public interface PropertyTaxDuesRepository extends JpaRepository<PropertyTaxDuesEntity, Integer>{

	@Query(value = "SELECT * FROM property_tax_dues where  process_queueId=:processQueueId ", nativeQuery = true)
	public List<PropertyTaxDuesEntity> findByprocessQueueId(int processQueueId);
	
}
