package com.cg.bmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bmd.dto.DoctorResponse;
import com.cg.bmd.dto.PatientResponse;
import com.cg.bmd.entities.Admin;
import com.cg.bmd.exception.AdminNotFoundException;
import com.cg.bmd.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired // creates instances for getter setter nd constructors of a class
	private AdminRepository adminRepository; // injecting dependencies for serviceimpl class

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
/*
	@Override
	public List<PatientResponse> getJoinInfo() {
		// TODO Auto-generated method stub
		return adminRepository.getJoinInfo();
	}

	@Override
	public List<DoctorResponse> getADJoinInfo() {
		// TODO Auto-generated method stub
		return adminRepository.getADJoinInfo();
	}
*/

	@Override
	public List<Admin> fetchAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
}
