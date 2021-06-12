package com.cg.bmd.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.entities.Patient;
import com.cg.bmd.entities.Treatment;
import com.cg.bmd.repository.TreatmentRepository;


@Service
public class TreamentServiceImpl implements ITreatmentService{
	
	Logger logger = LoggerFactory.getLogger(TreamentServiceImpl.class);
	
	@Autowired
	private TreatmentRepository treatmentRepository;

	@Override
	public Treatment addTreatment(Treatment treatment) {
		// TODO Auto-generated method stub
		
		logger.info(" TreatmentDetails added successfully !!");
		return treatmentRepository.save(treatment);
	}

	@Override
	public Treatment fetchTreatmentById(int treatmentId)   {
		// TODO Auto-generated method stub
		Treatment treatment = null;
		Optional<Treatment> optional = treatmentRepository.findById(treatmentId);
		if(optional.isPresent())
			treatment = optional.get();
		return treatment;

	}

	@Override
	public List<Treatment> fetchAllTreatments() {
		// TODO Auto-generated method stub
		return treatmentRepository.findAll();
	}

	@Override
	public Treatment fetchTreatmentByPatientId(int patientId) {
		// TODO Auto-generated method stub
		return treatmentRepository.getById(patientId);
	}

	
}
