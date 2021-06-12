package com.cg.bmd.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.entities.Doctor;
import com.cg.bmd.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient , Integer>{


	
	// public List<Patient> findPatientListByDoctor(Doctor doctor);
	 //public List<Patient> findPatientListByDate(LocalDate appdate);


}
