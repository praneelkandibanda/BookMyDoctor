package com.cg.bmd.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;
import com.cg.bmd.entities.Appointment;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Feedback;
import com.cg.bmd.entities.Patient;
import com.cg.bmd.exception.AdminNotFoundException;
import com.cg.bmd.repository.AdminRepository;
import com.cg.bmd.repository.AppointmentRepository;
import com.cg.bmd.repository.DoctorRepository;
import com.cg.bmd.repository.FeedbackRepository;
import com.cg.bmd.repository.PatientRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired // creates instances for getter setter nd constructors of a class
	private AdminRepository adminRepository; // injecting dependencies for serviceimpl class

	@Autowired 
	private DoctorRepository docRepository;
	
	@Autowired
	private AppointmentRepository appRepository;
	
	@Autowired
	private FeedbackRepository feedRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	
	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);	
	@Override 
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void removeAdmin(int adminId) throws AdminNotFoundException {
		
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (!admin.isPresent())
			throw new AdminNotFoundException();
		
		adminRepository.deleteById(adminId);

		 
	}

	@Override
	public Admin viewAdmin(int adminId) throws AdminNotFoundException {

		Optional<Admin> admin = adminRepository.findById(adminId);
		if (!admin.isPresent())
			throw new AdminNotFoundException();

		return admin.get();

	}

	@Override
	public List<PatientResponse> getJoinAPInfo() {
		// TODO Auto-generated method stub
		return adminRepository.getJoinAPInfo();
	}

	@Override
	public List<DoctorResponse> getJoinADInfo() {
		// TODO Auto-generated method stub
		return adminRepository.getJoinADInfo();
	}


	@Override
	public List<Admin> fetchAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
	
	
	@Override
	public List<Doctor> getDoctorList() {
		
		logger.info(" Successfully fetched all Doctor Details from db!!!");
		return docRepository.findAll();
	}


	public List<Appointment> listOfApp(){
		logger.info("List of Appointment");
		return appRepository.findAll();
		
	}

	public List<Feedback> listOfFeedbacks(){
		logger.info("List of Feedbacks given by Patients !!!" );
		return feedRepository.findAll() ;
		
	}
	
	public List<Patient> listOfPatients(){
		logger.info("List of Feedbacks given by Patients !!!" );
		return patientRepository.findAll() ;
		
	}

}
