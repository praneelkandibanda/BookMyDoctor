package com.cg.bmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("SELECT new com.cg.bmd.dto.PatientResponse(a.adminName , p.patientName)FROM Admin a JOIN a.patients p")
	public List<PatientResponse> getJoinAPInfo();
	
	@Query("SELECT new com.cg.bmd.dto.DoctorResponse(a.adminName ,  d.doctorName) FROM Admin a JOIN a.doctors d")
	public List<DoctorResponse> getJoinADInfo();
	
}
