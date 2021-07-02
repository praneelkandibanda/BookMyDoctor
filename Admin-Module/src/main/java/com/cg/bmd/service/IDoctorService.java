package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

@Service
public interface IDoctorService {
	
	public Doctor addDoctor(Doctor bean);
	
	public Doctor updateDoctorProfile(Doctor bean);
	
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException;
	
	public void removeDoctor(int doctorId) throws DoctorNotFoundException;
	
	public List<Doctor> getDoctorList();


	public List<Doctor> getBySpeciality(String speciality);
	 	 
    public List<AppointmentResponse> findAppointmentDetails(int doctorId);
    
    public List<FeedbackResponse> findFeedbackDetails(int doctorId);

	//List<Patient> listOfPatients(int doctorId);



}
