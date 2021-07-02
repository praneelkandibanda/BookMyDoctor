package com.cg.bmd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.FeedbackResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.repository.AppointmentRepository;
import com.cg.bmd.repository.AvailabilityRepository;
import com.cg.bmd.repository.DoctorRepository;
import com.cg.bmd.repository.FeedbackRepository;
import com.cg.bmd.repository.PatientRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired 
	private DoctorRepository docRepository; // dependency injection
	
	@Autowired
	private AppointmentRepository appRepository;
	
	@Autowired
	private FeedbackRepository feedRepository;
	
	@Autowired
	private PatientRepository patientRepository;



	@Override
	public Doctor addDoctor(Doctor bean) {
		
		logger.info("Doctor Added Successfully!!");
		return docRepository.save(bean);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		logger.info("Updated Doctor profile!!!");
		return docRepository.save(bean);
	}

	@Override
	public void removeDoctor(int doctorId) throws DoctorNotFoundException {
		
		logger.info("Successfully Removed Doctor from Table !!!");

		Optional<Doctor> doctor = docRepository.findById(doctorId);
		if (!doctor.isPresent())
			throw new DoctorNotFoundException();
		
		docRepository.deleteById(doctorId);

	}
	


	public List<Doctor> getDoctorList() {
		
		logger.info(" Successfully fetched all Doctor Details from db!!!");
		return docRepository.findAll();
	}
	
	@Override
	public Doctor getDoctor(int doctorId) throws DoctorNotFoundException{
		
		logger.info("Successfully fetched details of dctr by entering his id !!");

		Optional<Doctor> doctor = docRepository.findById(doctorId);
		if (!doctor.isPresent())
			throw new DoctorNotFoundException();
		return doctor.get();

	}
	

	

//		@Override
//		public List<PatientResponse> getDPJoin() {
//			
//			logger.info("List of Doctor-Patients !!!!");
//			return docRepository.getDPJoin();
//		}


		@Override
		public List<Doctor> getBySpeciality(String speciality) {
			
			logger.info("Fetched list by DoctorSpeciality!!! ");
			return docRepository.findBySpeciality(speciality);
		}

		
//		@Override
//		public List<Patient> listOfPatients(int doctorId) {
//			// TODO Auto-generated method stub
//			logger.info("Patients fetched by Doctor Id!!!");
//			return patientRepository.findAll();
//		}

		@Override
		   public List<AppointmentResponse> findAppointmentDetails(int doctorId){
			logger.info("Displays List of Doctor-Appointments");
			return docRepository.getAppointmentDetails(doctorId);
		}

		@Override
		public List<FeedbackResponse> findFeedbackDetails(int doctorId) {
			// TODO Auto-generated method stub
			return docRepository.getFeedbackDetails(doctorId);
		}
		
}
