package com.cg.bmd.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.PatientNotFoundException;
import com.cg.bmd.service.IPatientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/patients")


public class PatientController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private IPatientService patientService; // Here patientService is a obj for interface
	                          // class(serviceImpl) @Autowired creates objcts for implclass
	
	@PostMapping("/addPatient")
	@ApiOperation("Adding New Patient Record ")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient) {
		logger.info("Adding a Patient : " + patient);
		Patient p = patientService.addPatient(patient);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@PutMapping("/updatePatient")
	@ApiOperation("Updates Patient Records")
	
	public Patient update(@Valid @RequestBody Patient patient) {
		logger.info("Update a Patient : " + patient);

		return patientService.updatePatientDetail(patient) ;
		
	}


	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing Patient Record")
	public ResponseEntity<Void> delete(@PathVariable int id) throws PatientNotFoundException {
		logger.info("Deleting a customer!!");
		patientService.removePatientDetail(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
