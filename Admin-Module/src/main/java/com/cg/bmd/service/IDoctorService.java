package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;

@Service
public interface IDoctorService {
	
	public Doctor addDoctor(Doctor bean);
	
	public Doctor updateDoctorProfile(Doctor bean);
	
	public AvailabilityDates addAvailability(AvailabilityDates bean);
	
	public AvailabilityDates updateAvailability(AvailabilityDates bean);

	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException;
	
	public void removeDoctor(int doctorId) throws DoctorNotFoundException;
	
	public List<Doctor> getDoctorList();

	public List<PatientResponse> getDPJoin();


//	Doctor getPatientListByDoctor(String doctorName);

	Doctor getPatientsByDoctor(int doctorId);

	 public List<Doctor> getBySpeciality(String speciality);
	 
//	 public List<Patient> getPatientByDoctor(int doctorId);
	 
	 public List<AppointmentResponse> getDAJoin(); // ->Appointment
//	 
     public Doctor getByDoctorName(String doctorName); //->Appointment

	 public Doctor getAppointmentByDoctor(int doctorId);


}
