package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{

	
	
}


