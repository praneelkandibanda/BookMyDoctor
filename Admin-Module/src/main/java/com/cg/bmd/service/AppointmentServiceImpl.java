package com.cg.bmd.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.exception.AppointmentNotFoundException;
import com.cg.bmd.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	

	Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	
	@Override
	public List<Appointment> fetchAll() {
		return appointmentRepository.findAll();
	}
	
	
	@Override
	public Appointment getAppointment(int appointmentId) throws AppointmentNotFoundException {
		
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
		if (!appointment.isPresent())
			throw new AppointmentNotFoundException();

		return appointment.get();
		
	}

	
	@Override
	public Appointment addAppointment(Appointment app) {
		logger.info("inside addAppointment method of AppointmentServiceImpl");
		return appointmentRepository.save(app);
	}
	
	@Override
	public void deleteAppointment(int appointmentid) throws AppointmentNotFoundException {
		Optional<Appointment> appointment = appointmentRepository.findById(appointmentid);
		if (!appointment.isPresent())
			throw new AppointmentNotFoundException();

		appointmentRepository.deleteById(appointmentid);
	}

	@Override
	
	public  Appointment updateAppointment(Appointment app) {
		return appointmentRepository.save(app);
	}


//	@Override
//	public List<AppointmentResponse> getDoctorAppointmentJoin() {
//		
//		logger.info("Successfully added Doctor-Application");
//		return appointmentRepository.findDAJoin();
//	}


//	@Override
//	public Appointment getAppointmentListByDoctor(int doctorId) {
//		
//		logger.info("Displays List Of Appointment List!!!!");
//		return appointmentRepository.getById(doctorId);
//	}

}
