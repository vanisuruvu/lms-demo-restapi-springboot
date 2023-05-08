package com.ninja.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.lms.entity.BatchEntity;
import com.ninja.lms.jpa.BatchRepository;
import com.ninja.lms.entity.ProgramEntity;
import com.ninja.lms.jpa.ProgramRepository;
//import com.bezkoder.spring.hibernate.onetomany.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/")
public class BatchController {

	// BatchEntity is the Batch Object

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	ProgramRepository programRepository;
	
//	// Get Batches for ProgramId
//	  @GetMapping("/programs/batches")
//	  public List<BatchEntity> getAllBatchesByProgramId(@RequestParam(value = "programId") String programId) {
//	    if (!programRepository.existsById(Integer.parseInt(programId))) {
////	      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
//	    }
//
//	    List<BatchEntity> batches = new ArrayList<BatchEntity>();
//	    batchRepository.findAllByBatchProgramID(programId).forEach(batches::add);
//	    return batches;
//	  }

	// get all Batches for given programId
	@GetMapping("/programs/{batchProgramId}/batches")  
	public List<BatchEntity> retriveAllBatches(@PathVariable int batchProgramId)  
	{  
	Optional<ProgramEntity> programOptional= programRepository.findById(batchProgramId);  
	if(!programOptional.isPresent())  
	{  
//	throw new UserNotFoundException("id: "+ programId);  
	}  
	return programOptional.get().getBatches();  
	}  
	
	
	// Get All Batches
	@GetMapping("/batches")
	List<BatchEntity> all(){
		List<BatchEntity> entities = new ArrayList<BatchEntity>();
		batchRepository.findAll().forEach(entities::add);
		
		return entities;
	}

	// Get Single Batch
	@GetMapping("/batches/{id}")
	Optional <BatchEntity> findBatch(@PathVariable Integer id){
		return batchRepository.findById(id);
	}

	// Create New Batch
	@PostMapping("/batches")
	BatchEntity createBatch (@RequestBody BatchEntity newBatch) {
		return batchRepository.save(newBatch);
	}

	// Update Batch Information
	@PutMapping("/batches/{id}")
	BatchEntity updateBatch (@RequestBody BatchEntity updatedBatch, @PathVariable Integer id) {
		return batchRepository.save(updatedBatch);
	}

	// Delete Single Batch
	@DeleteMapping ("/batches/{id}")
	void deleteBatch(@PathVariable Integer id){
		batchRepository.deleteById(id);
	}
	
	@GetMapping("/batches/program/{programId}")
	List<BatchEntity> findBatches(@PathVariable Integer programId){
		
		List<BatchEntity> entities = new ArrayList<BatchEntity>();
		batchRepository.findAll().stream()
			.filter(e->(e.getBatchProgramID().equals(String.valueOf(programId)))).forEach(entities::add);
		return entities;
	}

}
