package com.cg.bmd.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.bmd.dto.AppointmentResponse;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.exception.AppointmentNotFoundException;

public interface IAppointmentService {

	List<Appointment> fetchAll();

	Appointment getAppointment(int appointmentId) throws AppointmentNotFoundException;

	Appointment addAppointment(Appointment app);

	void deleteAppointment(int appointmentid) throws AppointmentNotFoundException;

	Appointment updateAppointment(Appointment app);
	

	List<Appointment> getAppointment(Date appointmentDate);
	
//	public List<AppointmentResponse> getDoctorAppointmentJoin();
	
//	public Appointment getAppointmentListByDoctor(int doctorId);
	
	
	

}
