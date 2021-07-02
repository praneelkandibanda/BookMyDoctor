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

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.AdminNotFoundException;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.exception.PatientNotFoundException;
import com.cg.bmd.service.IAdminService;
//import com.cg.bmd.service.IAdminServiceImpl;
import com.cg.bmd.service.IDoctorService;
import com.cg.bmd.service.IPatientService;

import io.swagger.annotations.ApiOperation;

@RestController  //
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class); 
	//Spring Boot offers considerable support for configuring the logger to meet our logging requirements.

	
	@Autowired
	private IAdminService service;
	
//	@Autowired
//	private IDoctorService doctorService;
	
//	@Autowired
//	private IPatientService patientService;
	
	@GetMapping("/{name}") // 
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		return "<h1>Welcome to Spring Boot" + name + "</h1>";

	}
	
	@PostMapping("/save")
	@ApiOperation(" Adding new Admin Record")
	
	public ResponseEntity<Admin> save(@Valid @RequestBody Admin admin) {
		logger.info("Adding a Admin : " + admin);
		Admin a = service.addAdmin(admin);
		return new ResponseEntity<>(a, HttpStatus.CREATED);
	}


	@PutMapping("/update")
	@ApiOperation("Updating the exsisting record ")
	
	public Admin update(@Valid @RequestBody Admin admin) {
		logger.info(" Exsisting record is updated");
		return service.updateAdmin(admin);

	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	@ApiOperation("Delete an Existing Admin Record")
	public ResponseEntity<Void> deleteadmin(@PathVariable int id)throws AdminNotFoundException  {
		logger.info("Deleting a Admin!!");
	     service.removeAdmin(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/fetchAdmins/{id}")
	@ApiOperation("Retriving Admin list by ID")
	public Admin fetchAdmin(@PathVariable int id) throws NumberFormatException,AdminNotFoundException{
		logger.info("Inside fetchAdmin %s", id);
 
		return service.viewAdmin(id);
		
	}
	
	@GetMapping("/fetchAllAdmin")
	public List<Admin> fetchAllAdmin() {
		// TODO Auto-generated method stub
		return service.fetchAllAdmin();
	}

	@GetMapping("/fetchAllPatients")
	@ApiOperation("Retriving Patients list")
	public List<Patient> fetch(){
		return service.listOfPatients();
		
	}
	
	@GetMapping("/fetchAllDoctors")
	@ApiOperation("Retriving Patients list")
	public List<Doctor> fetchDoctors(){
		return service.getDoctorList();
		
	}
	
	@GetMapping("/fetchAllAppointments")
	@ApiOperation("Retriving Patients list")
	public List<Appointment> fetchAppointment(){
		return service.listOfApp();
		
	}

	@GetMapping("/fetchAllFeedbacks")
	@ApiOperation("Retriving Patients list")
	public List<Feedback> fetchFeedbacks(){
		return service.listOfFeedbacks();
		
	}

	
	

	

	/*
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
	*/



	
	//Patient
  /**
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
	**/
	
	
     /*
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
	*/
	
	@GetMapping("/AdminPatient/getJoinInfo")
	public List<PatientResponse> getJoinInfo(){
		return service.getJoinAPInfo();
		
	}
	
	@GetMapping("/AdminDoctor/getInfo")
	 public List<DoctorResponse> getADJoinInfo(){
		return service.getJoinADInfo();
		
	}

	

}
