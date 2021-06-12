package com.cg.bmd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;
import com.cg.bmd.exception.AdminNotFoundException;

@Service
public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public List<Admin> fetchAllAdmin();
	
	public void removeAdmin(int adminId) throws AdminNotFoundException;
	
	public Admin viewAdmin(int adminId) throws AdminNotFoundException;

	// public List<PatientResponse> getJoinInfo();

	//public List<DoctorResponse> getADJoinInfo();

}
