package com.ninja.lms.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.lms.entity.BatchEntity;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Integer> {
//	List<BatchEntity> findAllByBatchProgramID(String programId);
 
}