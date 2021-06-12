package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.entities.Doctor;
//import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.PatientNotFoundException;

@Service
public interface IPatientService {
	
	public Patient addPatient(Patient bean);
	
	public Patient updatePatientDetail(Patient bean);
	
	public void removePatientDetail(int patientId) throws PatientNotFoundException;
	
	public Patient fetchPatientById(int patientId) throws PatientNotFoundException;
	public List<Patient> getAllPatient();
	//public List<Patient> findPatientListByDate(LocalDate appdate);

}
