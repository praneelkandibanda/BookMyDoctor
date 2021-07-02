package com.cg.bmd.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cg.bmd.dto.UserRegistrationDto;
import com.cg.bmd.entities.User;


public interface UserService extends UserDetailsService{
	

	User save(UserRegistrationDto registrationDto);

}
