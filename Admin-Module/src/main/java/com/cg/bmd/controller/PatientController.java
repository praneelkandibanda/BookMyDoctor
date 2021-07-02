package com.cg.bmd.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.PatientNotFoundException;
import com.cg.bmd.service.IDoctorService;
import com.cg.bmd.service.IPatientService;

import io.swagger.annotations.ApiOperation;

@RestController // It is a combination of @Controller and @ResponseBody in single statement.
              //It is the way that the HTTP response body is created.
@RequestMapping("/patients")


public class PatientController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private IPatientService patientService; // Here patientService is a obj for interface
	                          // class(serviceImpl) @Autowired creates objcts for implclass which
	                         // 
	
	
	@Autowired
	private IDoctorService doctorService;
	
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


//	@DeleteMapping("/delete/{id}")
//	@ApiOperation("Delete an Existing Patient Record")
//	public ResponseEntity<Void> delete(@PathVariable int id) throws PatientNotFoundException {
//		logger.info("Deleting a customer!!");
//		patientService.removePatientDetail(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//	}
	
	@GetMapping("/fetchAllPatients")
	@ApiOperation("Retriving Patients list")
	public List<Patient> fetch(){
		return patientService.getAllPatient();
		
	}
	

	@DeleteMapping("/deletePatient/{id}")
	@ApiOperation("Delete an Existing Patient Record")
	public ResponseEntity<Void> deletePatient(@PathVariable int id)throws PatientNotFoundException  {
		logger.info("Deleting a Patient!!");
		patientService.removePatientDetail(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/fetchPatientById/{id}")
	@ApiOperation("Retriving Patient list by ID")
	public Patient fetchPatientById(@PathVariable int id) throws NumberFormatException, PatientNotFoundException{
		logger.info("Inside fetchPatientById %s", id);
 
		return patientService.fetchPatientById(id);
		
	}

//	@GetMapping("/findPatientByDoctor/{id}")
//	
//	public Doctor findPatientsByDoctor(@PathVariable int id) {
//		
//		logger.info("Patients fetched by Doctor Id!!!");
//		return doctorService.getPatientsByDoctor(id);
//	}

	

}
