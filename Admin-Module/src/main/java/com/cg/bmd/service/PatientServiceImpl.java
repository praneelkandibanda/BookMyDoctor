package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.PatientNotFoundException;
import com.cg.bmd.repository.PatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient addPatient(Patient bean) {
		// TODO Auto-generated method stub
		return patientRepository.save(bean) ;
	}

	@Override
	public Patient updatePatientDetail(Patient bean) {
		// TODO Auto-generated method stub
		return patientRepository.save(bean);
	}

	@Override
	public void removePatientDetail(int patientId) throws PatientNotFoundException{

		Optional<Patient> patient = patientRepository.findById(patientId);
		if (!patient.isPresent())
			throw new PatientNotFoundException();
		
		patientRepository.deleteById(patientId);

	}
	

	@Override
	public Patient fetchPatientById(int patientId ) throws PatientNotFoundException {

		Optional<Patient> patient = patientRepository.findById(patientId);
		if (!patient.isPresent())
			throw new PatientNotFoundException();
		
		return patient.get();
	}

	@Override
	public List<Patient> getAllPatient() {

		return patientRepository.findAll();
	}


//	@Override
//	public List<Patient> findPatientListByDoctor(Doctor doctor) {
//		// TODO Auto-generated method stub
//		List<Patient> patients = new ArrayList<>();
//		patientRepository.findPatientListByDoctor(doctor).forEach(patients :: add);
//		return patients;
//	}
	

	/*
	  @Override
	 
	public List<Patient> findPatientListByDate(LocalDate appdate) {
		// TODO Auto-generated method stub
		return patientRepository.findPatientListByDate(appdate);
	}
	*/

}
