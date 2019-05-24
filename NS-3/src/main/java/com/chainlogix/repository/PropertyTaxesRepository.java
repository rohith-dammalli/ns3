package com.chainlogix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chainlogix.entity.PropertyTaxesEntity;

public interface PropertyTaxesRepository extends JpaRepository<PropertyTaxesEntity, Integer>{
	

	@Query(value = "SELECT * FROM property_taxes where  process_queueId=:processQueueId ", nativeQuery = true)
	List<PropertyTaxesEntity> findByprocessQueueId(Integer processQueueId);

}
