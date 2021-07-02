package com.cg.bmd.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.AvailabilityDates;
import com.cg.bmd.entities.Doctor;

public interface IAvailabilityDatesService {
	
	public AvailabilityDates addAvailability(AvailabilityDates bean);
	
	public AvailabilityDates updateAvailability(AvailabilityDates bean);
	
	public List<AvailabilityDates> fetchAllDates();



	

}
