package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.ClientDataEntity;

@Repository
public interface ClientDataRepository extends JpaRepository<ClientDataEntity, Integer> {

	
	public ClientDataEntity findFirstByNameOrderByClientpkDesc(String Name);
}
