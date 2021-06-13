package com.cg.bmd.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
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
	
	@Autowired
	private IPatientService patientService;
	
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
	
	/*
	@GetMapping("/patientsList/getByDoctor/{id}")
	
	public List<Patient> findByDoctor( @PathVariable Doctor id){
		return doctorService.findPatientListByDoctor(id);
		
	}*/

//	@GetMapping("/doctorPatient/getDPJoin")
//	 public List<PatientResponse> getDPJoin(){
//		return doctorService.getDPJoin();
//		 
//	 }
	

//	@GetMapping("/findPatientListByName/{doctorName}")
//	public Doctor findPatientListByDoctor(@PathVariable String doctorName) {
//		// TODO Auto-generated method stub
//		return  doctorService.getPatientListByDoctor(doctorName);
//	}

	
	@GetMapping("/findBySpeciality/{speciality}")
	public List<Doctor> getBySpeciality(@PathVariable String speciality) {
		
		logger.info("Fetched list by DoctorSpeciality!!! ");
		return doctorService.getBySpeciality(speciality);
	}
	
	@GetMapping("/findPatientByDoctor/{id}")
	
	public Doctor findPatientsByDoctor(@PathVariable int id) {
		
		logger.info("Patients fetched by Doctor Id!!!");
		return doctorService.getPatientsByDoctor(id);
	}

	@GetMapping("/getDAJoin")
	
	public List<AppointmentResponse> getDAJoin() {
		logger.info("Displays List of Doctor-Appointments");
		return doctorService.getDAJoin();
	}


//	@GetMapping("/getByDoctorName/{doctorName}")
//	
//	public Doctor getByDoctorName(@PathVariable String doctorName) {
//		logger.info("List of Patient is fetched by DoctorName");
//		return doctorService.getByDoctorName(doctorName);
//	}

	@GetMapping("/findAppointmentByDoctor/{doctorId}")
	
	public Doctor findAppointmentByDoctor(@PathVariable int doctorId) {
		
		logger.info("Patients fetched by Doctor Id!!!");
		return doctorService.getAppointmentByDoctor(doctorId);
	}
	
	@PostMapping("/addAvailabilityDates")
	
	public ResponseEntity<AvailabilityDates> saveAvailabilityDates(@Valid @RequestBody AvailabilityDates date) {
		logger.info("Adding a Date : " + date);
		AvailabilityDates d = aDService.addAvailability(date);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}


	

//	@GetMapping("/findPatientListByDoctor/{doctorId}")
//	public List<Patient> getPatientByDoctor(@PathVariable int doctorId) {
//		
//		logger.info("List of Patient is fetched by DoctorId");
//		return doctorService.getPatientByDoctor(doctorId);
//	}

	
}
