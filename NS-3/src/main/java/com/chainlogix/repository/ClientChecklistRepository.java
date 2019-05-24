package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.ClientCheckListEntity;

@Repository
public interface ClientChecklistRepository extends JpaRepository<ClientCheckListEntity, Integer> {

	
	
	
}
