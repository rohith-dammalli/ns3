package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.ProcessMasterEntity;

@Repository
public interface ProcessMasterRepository extends JpaRepository<ProcessMasterEntity, Integer>{

}
