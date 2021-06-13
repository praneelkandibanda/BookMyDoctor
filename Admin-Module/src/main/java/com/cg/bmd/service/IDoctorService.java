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
	
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException;
	
	public void removeDoctor(int doctorId) throws DoctorNotFoundException;
	
	public List<Doctor> getDoctorList();

	public Doctor getPatientsByDoctor(int doctorId);

	public List<Doctor> getBySpeciality(String speciality);
	 	 
	public List<AppointmentResponse> getDAJoin(); // ->Appointment
	 
	public Doctor getAppointmentByDoctor(int doctorId);

    public Doctor getFeedbackByDoctor(int doctorId);


}
