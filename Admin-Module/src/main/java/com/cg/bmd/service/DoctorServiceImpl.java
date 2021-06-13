package com.cg.bmd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.DoctorNotFoundException;
import com.cg.bmd.repository.AvailabilityRepository;
import com.cg.bmd.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired 
	private DoctorRepository docRepository; // dependency injection
	
	

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
	

	@Override
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

		
		
//		@Override
//		public Doctor getPatientListByDoctor(String doctorName) {
//			
//			logger.info("Details are fetched by entering DoctorName !!");
//			return  docRepository.findByDoctorName(doctorName);
//		}


		@Override
		public List<Doctor> getBySpeciality(String speciality) {
			
			logger.info("Fetched list by DoctorSpeciality!!! ");
			return docRepository.findBySpeciality(speciality);
		}

		@Override
		public Doctor getPatientsByDoctor(int doctorId) {
			// TODO Auto-generated method stub
			logger.info("Patients fetched by Doctor Id!!!");
			return docRepository.findByDoctorId(doctorId);
		}

		@Override
		public List<AppointmentResponse> getDAJoin() {
			logger.info("Displays List of Doctor-Appointments");
			return docRepository.getDAJoin();
		}


//		@Override
//		public Doctor getByDoctorName(String doctorName) {
//			logger.info("List of Patient is fetched by DoctorName");
//			return docRepository.findByDoctorName(doctorName);
//		}

		@Override
		public Doctor getAppointmentByDoctor(int doctorId) {
			
			logger.info("List of Appointment ");
			return docRepository.findByDoctorId(doctorId);
		}

		public Doctor getFeedbackByDoctor(int doctorId) {
			
			logger.info("List of Feedback given by patient !!!");
			return docRepository.findByDoctorId(doctorId);
		}
	
}
