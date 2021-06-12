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

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.exception.AppointmentNotFoundException;
import com.cg.bmd.service.IAppointmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	
 
	Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	private IAppointmentService appointmentService;// CustomerService is a dependency of CustomerContoller

//	@Autowired
//	public  IDoctorService doctorservice;
	
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Appointments")
	public List<Appointment> fetch() {
		logger.info("Fetching all appointments!!");
		return appointmentService.fetchAll();
	}

	@GetMapping("/getById/{appointmentId}")
	@ApiOperation("Get Appointment By ID")
	public Appointment fetchById(@PathVariable int appointmentId) throws AppointmentNotFoundException {
		logger.info("Inside fetchById %s", appointmentId);
		return appointmentService.getAppointment(appointmentId);
	}
	

	@PostMapping("/save")
	@ApiOperation("Adding a appointment")
	public ResponseEntity<Appointment> save(@Valid @RequestBody Appointment app) {
		logger.info("Adding a appointment : " + app);
		Appointment appoint = appointmentService.addAppointment(app);
		return new ResponseEntity<>(appoint, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{appointmentId}")
	@ApiOperation("Delete an Existing Appointment")
	public ResponseEntity<Void> delete(@PathVariable int appointmentId) throws AppointmentNotFoundException {
		logger.info("Deleting a Appointment!!");
		appointmentService.deleteAppointment(appointmentId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	


	@PutMapping("/update")
	@ApiOperation("Update an Existing Customer Record")
	public void update(@Valid @RequestBody Appointment app) {
		logger.info("Updating a appointment");
		appointmentService.updateAppointment(app);
	}
	
//	@GetMapping("/getDAJoin")
//	public List<AppointmentResponse> getDoctorAppointmentJoin() {
//		
//		logger.info("Fetches all Doctor-Appointments");
//		return appointmentService.getDoctorAppointmentJoin();
//	}
//
//	@GetMapping("/getAppointmentListByDoctor/{doctorId}")
//	public Appointment getAppointmentListByDoctor(@PathVariable int doctorId) {
//		
//		logger.info("Fetches Appointment List!!!!");
//		return appointmentService.getAppointmentListByDoctor(doctorId);
//	}
//


	


}
