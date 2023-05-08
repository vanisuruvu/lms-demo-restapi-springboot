package com.ninja.lms.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninja.lms.entity.ProgramEntity;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {
 
}