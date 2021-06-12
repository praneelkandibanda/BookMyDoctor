package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bmd.entities.Patient;
import com.cg.bmd.entities.Treatment;

@Service
public interface ITreatmentService {

	public Treatment addTreatment(Treatment treatment);
	
	public Treatment fetchTreatmentById(int treatmentId);
	
	public List<Treatment> fetchAllTreatments();
	
	public Treatment fetchTreatmentByPatientId(int patientId);
}
