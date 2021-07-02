package com.cg.bmd.controller;

import java.util.ArrayList;
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
import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.FeedbackResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.service.IAvailabilityDatesService;
import com.cg.bmd.service.IDoctorService;
import com.cg.bmd.service.IPatientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private IDoctorService doctorService;
	
//	@Autowired
//	private IPatientService patientService;
	
	@Autowired
	private IAvailabilityDatesService aDService;

	@PostMapping("/saveDoctor")
	@ApiOperation(" Adding a Doctor Record")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor) {
		logger.info("Adding a Doctor : " + doctor);
		Doctor doc = doctorService.addDoctor(doctor);
		return new ResponseEntity<>(doc, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateDoctor")
	@ApiOperation(" Updating a Doctor record")
	
	public Doctor update(@Valid @RequestBody Doctor doctor) {
		logger.info("Successfully updated  Doctordetails: " + doctor);
		return doctorService.updateDoctorProfile(doctor);
		
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	@ApiOperation("Delete an Existing Doctor Record")
	public ResponseEntity<Void> deletedoc(@PathVariable int id)throws DoctorNotFoundException  {
		logger.info("Deleting a Patient!!");
	     doctorService.removeDoctor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/fetchAllDoctor")
	@ApiOperation("Retriving Doctors list")
	public List<Doctor> fetchdoc(){
		return doctorService.getDoctorList();
		
	}
	
	@GetMapping("/fetchDoctors/{id}")
	@ApiOperation("Retriving Doctor list by ID")
	public Doctor getDoctor(@PathVariable int id) throws NumberFormatException, DoctorNotFoundException{
		logger.info("Inside getDoctor %s", id);
 
		return doctorService.getDoctor(id);
		
	}
	
	@GetMapping("/findBySpeciality/{speciality}")
	public List<Doctor> getBySpeciality(@PathVariable String speciality) {
		
		logger.info("Fetched list by DoctorSpeciality!!! ");
		return doctorService.getBySpeciality(speciality);
	}
	

	@GetMapping("/listAppointments/{doctorId}")
	
	public List<AppointmentResponse> listOfApp(@PathVariable int doctorId) {
		logger.info("Displays List of Doctor-Appointments");
		return doctorService.findAppointmentDetails(doctorId);
	}
	

	@GetMapping("/getAllFeedbacks/{doctorId}")
	@ApiOperation("Fetch all Feedbacks")
	public List<FeedbackResponse> fetchFeedback(@PathVariable int doctorId) {
		logger.info("Fetching all Feedbacks!!");
		return doctorService.findFeedbackDetails(doctorId);
	}


//	@GetMapping("/getAllPatients/{doctorId}")
//	@ApiOperation("Fetch all Patients")
//	public List<Patient> fetchPatient(@PathVariable int doctorId) {
//		logger.info("Fetching all Patients!!");
//		return doctorService.listOfPatients(doctorId);
//	}



	
	@PostMapping("/addAvailabilityDates")
	
	public ResponseEntity<AvailabilityDates> saveAvailabilityDates(@Valid @RequestBody AvailabilityDates date) {
		logger.info("Adding a Date : " + date);
		AvailabilityDates d = aDService.addAvailability(date);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}


	


	
}
