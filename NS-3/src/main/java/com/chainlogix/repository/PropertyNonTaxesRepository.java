package com.chainlogix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chainlogix.entity.PropertyNonTaxesEntity;

public interface PropertyNonTaxesRepository extends JpaRepository<PropertyNonTaxesEntity, Integer>{

	
	@Query(value = "SELECT * FROM property_non_taxes where  process_queueId=:processQueueId ", nativeQuery = true)
	public List<PropertyNonTaxesEntity> findByprocessQueueId(int processQueueId);
}
