package com.ninja.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import com.ninja.lms.EntityNotFoundException;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.ninja.lms.entity.BatchEntity;
import com.ninja.lms.entity.ProgramEntity;
import com.ninja.lms.jpa.BatchRepository;
import com.ninja.lms.jpa.ProgramRepository;

import javassist.NotFoundException;
//import com.ninja.lms.ResourceNotFoundException;


@RestController
@RequestMapping("/")
public class ProgramController {

	// ProgramEntity is the Program Object

	@Autowired
	ProgramRepository programRepository;
	
//	@Autowired
//	BatchRepository batchRepository;

	// Get All Programs
	@GetMapping("/programs")
	List<ProgramEntity> all(){
		List<ProgramEntity> entities = new ArrayList<ProgramEntity>();
		programRepository.findAll().forEach(entities::add);
//		return demoRepository.findAll();
		return entities;
	}

	// Get Single Program
	@GetMapping("/programs/{id}")
	ProgramEntity findProgram(@PathVariable Integer id) throws EntityNotFoundException{
//		Optional<ProgramEntity> program = programRepository.findById(id);
//		if(optProgram.isPresent()){
//			return Optional.of(optProgram.get());
//		}else{
//			throw new NotFoundException("Program not found with id"+id);
//		}
//		if(program.isEmpty()) {
//			System.out.println("Here in getProgram not found");
//			throw new EntityNotFoundException(ProgramEntity.class, "id", id.toString());
//		}
		
		Optional<ProgramEntity> program = programRepository.findById(id);
        if (program.isEmpty()) {
            throw new EntityNotFoundException(ProgramEntity.class, "id", id.toString());
        }
		return program.get();
	}

	// Create New Program
	@PostMapping("/programs")
	ProgramEntity createProgram (@RequestBody @Valid ProgramEntity newProgram) {
		return programRepository.save(newProgram);
	}

	// Update Program Information
	@PutMapping("/programs/{id}")
	ProgramEntity updateProgram (@RequestBody ProgramEntity updatedProgram, 
			@PathVariable Integer id) {
		return programRepository.save(updatedProgram);
	}

	// Delete Single Program
	@DeleteMapping ("/programs/{id}")
	ResponseEntity<?> deleteProgram(@PathVariable Integer id) {
		programRepository.deleteById(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
//		return programRepository.findById(id).map(post -> {
//            programRepository.delete(post);
//            return ResponseEntity.ok().build();
//            return new ResponseEntity<Object>("Employee deleted successfully!.", HttpStatus.OK);
//        }).get(); //.orElseThrow(() -> new ResourceNotFoundException("ProgramId " + id + " not found"));

	}
	
//	@GetMapping("/batches/program/{programId}")
//	List<BatchEntity> findBatches(@PathVariable Integer programId){
//		
//		List<BatchEntity> entities = new ArrayList<BatchEntity>();
//		batchRepository.findAll().stream()
//			.filter(e->(e.getBatchProgramID().equals(String.valueOf(programId)))).forEach(entities::add);
//		return entities;
//	}

}
