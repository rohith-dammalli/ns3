package com.chainlogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chainlogix.entity.ProcessStatusEntity;

@Repository
public interface ProcessStatusRepository extends JpaRepository<ProcessStatusEntity, Integer>{

}
