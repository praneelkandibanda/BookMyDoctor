package com.cg.bmd.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.entities.Admin;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.entities.Treatment;
import com.cg.bmd.service.ITreatmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/treatmentDetails")
public class TreatmentController {
	
	Logger logger = LoggerFactory.getLogger(TreatmentController.class);
	@Autowired
	private ITreatmentService treatService;
	
	@PostMapping("/addTreatmentDetails")
	@ApiOperation("treatment given by Doctor")
	public ResponseEntity<Treatment> save(@RequestBody Treatment treatment) {
		
		logger.info("Adding TreamentDetails!!!!");
		Treatment t =treatService.addTreatment(treatment);
		return  new ResponseEntity<>(t, HttpStatus.CREATED);
		
	}
	

	
	@GetMapping("/fetchTreatmentDetails/{patientId}")
	@ApiOperation("TreatmentDetails fetched by id")
	
	public Treatment fetchTreatment(@PathVariable int patientId) {
		return treatService.fetchTreatmentByPatientId(patientId);
		
	}
	
	@GetMapping("/fetchAllTreatments")
	@ApiOperation("All Treatment Details")
	
	public List<Treatment> fetchAllTreatments(){
		return treatService.fetchAllTreatments();
		
	}
	

}
